var botonPaso1 = document.getElementById('boton1');
var cboDoctor = document.getElementById('cboDoctor');
var cboEspecialidad = document.getElementById('cboEspecialidad');
var botonante = document.getElementById('botonante');
var formulario = document.getElementById('formularioCita');
var calendarObj = new Calendar();
var botonsgt2 = document.getElementById('boton2');

window.onload = pageLoad();

function pageLoad(){
    llenarComboEspecialidad();
    MostrarTPD();
    MostrarMDP();
    MostrarAseg();

    let cboEspecialidad = document.getElementById('cboEspecialidad');
    let valorEspecialidad = cboEspecialidad.value;
    
    disableButton();

    if (valorEspecialidad === '') {
        return;
    }

    llenarComboDoctores();
    
}

function disableButton(){
    if(cboEspecialidad.value === '0' || cboDoctor.value === '0'){
        botonPaso1.disabled=true;
        return;
    }
    botonPaso1.disabled=false;
}

function llenarComboDoctores(){
    let valorCombo = cboEspecialidad.value;
    var template = '';
    var formData = new FormData();

    formData.append('valorCombo',valorCombo);

    let url="http://localhost:8080/AdVitam/doctorxespecialidad/"+valorCombo;

    fetch(url)
        .then( res => res.json())
        .then( data => {
            
            template = '<option value="0" selected disabled>Selecione un doctor</option>';
            for(let valor of data){
                template += `<option value="${valor['id']}">${valor['nombredoctor'] + " " + valor['apellidodoctor']}</option>`;
            }
            cboDoctor.innerHTML=template;
        });
}

function llenarComboEspecialidad(){
    fetch('http://localhost:8080/AdVitam/listarEspecialidad')
        .then( res => res.json())
        .then( data => {
            template = '<option value="0" selected disabled>Selecione una especialidad</option>';
            for(let valor of data){
                template += `<option value="${valor['id']}">${valor['descripcion']}</option>`;
            }
            cboEspecialidad.innerHTML=template;
        });
}



cboEspecialidad.addEventListener('change', (event) =>{
    llenarComboDoctores();
    let botonPaso1 = document.getElementById('boton1');
    botonPaso1.disabled=true;

    var combo = document.getElementById("cboEspecialidad");
    var selected = combo.options[combo.selectedIndex].text;
    let especialidad = document.getElementById('EspeSelect');
    
    especialidad.innerHTML=selected;
    let precio = document.getElementById('costocita');
 

    let valorCombo = cboEspecialidad.value;
    var datos =new FormData();
    let template="";

    datos.append('valorCombo',valorCombo);

    fetch(`http://localhost:8080/AdVitam/precioxespecialidad/${valorCombo}`)
        .then(res => res.json())
        .then(data => {


             template= `${data[0].precio}.00`;
      
         precio.innerHTML=template; 
        });

      

});

cboDoctor.addEventListener('change', (event)=>{
    disableButton();
});


function getData(){
    let cboDoctor = document.getElementById('cboDoctor');
    let idDoctor = cboDoctor.value;
    let formData = new FormData();

    formData.append('idDoctor',idDoctor);

    fetch(`http://localhost:8080/AdVitam/horarioxdoctor/${idDoctor}`)
        .then(res => res.json())
        .then(data => {
            llenarArray(data);
        });
}

function llenarArray(data){
    let arrayDatos = [];
    for(let valor of data){
        arrayDatos.push({
                id: valor['id'],
                fecha: valor['fecha'],
                horaInicio: valor['horainicio'],
                horaFinal: valor['horafinal']
        });
    }

    calendarObj.runCalendar('calendar',data);
    let botonSiguiente = document.getElementById('boton2');
    botonSiguiente.disabled = true;
}

formulario.addEventListener('submit', function(e){
    e.preventDefault();
    let cboAseguradora = document.getElementById('cboAseguradora')
    let cboDocumento = document.getElementById('cboDocumento')
    let cboPago = document.getElementById('cboPago')
    let txtNombre = document.getElementById('name')
    let txtApellido = document.getElementById('ape')
    let txtTelefono = document.getElementById('celular')
    let txtCorreo = document.getElementById('correo')
    let txtDocumento = document.getElementById('doc');
    
    let datos =new FormData(formulario);
    let datos2 =new FormData();
    let fecha = traerFecha();
    let hora = traerHora();
    let precio= traerPrecio();
    
    
    datos.append('aseguradora', cboAseguradora.value);
    datos.append('nombrepaciente', txtNombre.value);
    datos.append('apellidopaciente', txtApellido.value);
    datos.append('telefono', txtTelefono.value);
    datos.append('correo', txtCorreo.value);
    datos.append('fechanac', '2001-07-10');
    datos.append('tipodocumento', cboDocumento.value);
    datos.append('nrodocumento', txtDocumento.value);
    datos.append('metodopago', cboPago.value);
    datos.append('doctor', cboDoctor.value);
    datos.append('fecha',fecha);
    datos.append('hora',hora);
    datos.append('estado',1);
    
    datos2.append('nombrepaciente', txtNombre.value);
    datos2.append('apellidopaciente', txtApellido.value);
    datos2.append('correo', txtCorreo.value);
    datos2.append('fecha',fecha);
    datos2.append('hora',hora);
    datos2.append('NombreDoctor', cboDoctor.options[cboDoctor.selectedIndex].text);
    datos2.append('Especialidad', cboEspecialidad.options[cboEspecialidad.selectedIndex].text);
    datos2.append('PrecioCita',precio);
    datos2.append('metodopago', cboPago.value);

    fetch('php/EnviarEmail.php',{
        method: 'POST',
        body: datos2
    })
        .then(res => res.json())
        .then(data => {
        });

        
    fetch('http://localhost:8080/AdVitam/agregarCita',{
        method: 'POST',
        body: datos
    })

});

function traerFecha(){
    let fecha = moment(calendarObj.selectedDate).format('YYYY-MM-DD');
    return fecha;
}
function traerHora(){
    let elTime = document.getElementById('containerHoras');
    let hora = elTime.querySelector('.horaSeleccionada');
    return hora.textContent; 
}

function traerPrecio(){
    let preciox= document.getElementById('costocita');
    let valpreciox= preciox.innerHTML;
        return valpreciox;
}

botonPaso1.addEventListener('click', (event)=>{
    getData();
});

botonante.addEventListener('click', (event)=>{
    let calendar = document.getElementById('calendar');
    let containerhoras = document.getElementById('containerHoras');

    calendar.innerHTML='';
    containerhoras.innerHTML = '';

    calendarObj.currentMonth = moment();
});


botonsgt2.addEventListener('click',(e)=>{
    let fechayhora = document.getElementById('fechyhora');
    let fecha = moment(traerFecha()).format('DD/MM/YYYY');
    let hora = traerHora();
    let template=` <label>Fecha y hora seleccinada: ${fecha} y ${hora}</label> `;

    fechayhora.innerHTML=template;
    
});


function MostrarTPD(){
    let cboa= document.getElementById('cboDocumento');
    fetch(`http://localhost:8080/AdVitam/listarTipoDocumento`)
    .then(res => res.json())
    .then(data => {
        template = '<option value="0" selected disabled>Selecione documento</option>';
        for(let valor of data){
            template += `<option value="${valor['id']}">${valor['descripcion_doc']}</option>`;
        }
        cboa.innerHTML=template;

    });

}

function MostrarMDP(){
    let cbomdp= document.getElementById('cboPago');
    fetch(`http://localhost:8080/AdVitam/listarMetodoPago`)
    .then(res => res.json())
    .then(data => {
        console.log(data);
        template = '<option value="0" selected disabled>Selecione documento</option>';
        for(let valor of data){
            template += `<option value="${valor['id']}">${valor['descripcionmetopago']}</option>`;
        }
        cbomdp.innerHTML=template;
        
    });
}

function MostrarAseg(){
    let cboasg= document.getElementById('cboAseguradora');
    fetch(`http://localhost:8080/AdVitam/listarAseguradora`)
    .then(res => res.json())
    .then(data => {
        template = '<option value="0" selected disabled>Selecione documento</option>';
        for(let valor of data){
            template += `<option value="${valor['id']}">${valor['descripcion_asg']}</option>`;
        }
        cboasg.innerHTML=template;
      
    });
}






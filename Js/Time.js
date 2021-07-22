class Time {
    constructor(){
        this.data = null;
        this.selectedDate = '';
        this.tiempoAtencion = '';
        this.tiempoOcupado = [];
        this.elTime = ''; 
        this.selectedTime = '';
    }

    runTime(id,data,selectedDate){
        this.data = data;
        this.selectedDate = selectedDate;
        this.elTime = document.getElementById(id);
        this.getAtentionTime();
    }

    getAtentionTime(){
        let cboEspecialidad = document.getElementById('cboEspecialidad');
        let valorCombo = cboEspecialidad.value;
        var formData = new FormData();
        let tiempoAtencion;

        formData.append('valorCombo',valorCombo);

        fetch(`http://localhost:8080/AdVitam/especialidadporid/${valorCombo}`)
            .then( res => res.json())
            .then( data => {
                this.getRegisteredAppointments(data.tiempoatencion);             
            });
        
    }

    getRegisteredAppointments(data1){
        let cboDoctor = document.getElementById('cboDoctor');
        let idDoctor = cboDoctor.value;
        let diaSeleccionado = moment(this.selectedDate).format('YYYY-MM-DD');
        var formData = new FormData();

        formData.append('idDoctor',idDoctor);
        formData.append('fecha',diaSeleccionado);

        fetch(`http://localhost:8080/AdVitam/traercita/${idDoctor}/${diaSeleccionado}`)
            .then( res => res.json())
            .then( data2 => {
                this.asignarData(data1, data2);
            });
    }

    asignarData(data1,data2){
        this.tiempoAtencion = data1;
        this.tiempoOcupado = data2;
        
        this.generateTime();
    }

    generateTime(){
        let diaSeleccionado = this.selectedDate;
        let containerHoras = document.getElementById('containerHoras');
        
        let cont = 1;
        let template = '';

        for(let valor of this.data){
            let dayData = new Date(valor['fecha']+"T00:00:00");
            let tiempoInicio = moment(valor['horainicio'],'HH:mm:ss')
            let tiempoFinal = moment(valor['horafinal'],'HH:mm:ss')

            if(moment(dayData).format('YYYY-MM-DD') === moment(diaSeleccionado).format('YYYY-MM-DD')){
                
                do{
                    template += `<div class="horas" id="botonN${cont}">${tiempoInicio.format('HH:mm')}</div>`;
                    cont++;
                    tiempoInicio = moment(tiempoInicio).add(this.tiempoAtencion,'m');              
                }while(tiempoInicio.isBefore(tiempoFinal));
            }
        }
        containerHoras.innerHTML = template;
        this.deleteRepeatingHours();
        this.addEventListenerToButtonsTime();
    }

    deleteRepeatingHours(){
        let buttonsTime = this.elTime.querySelectorAll('.horas');
        let horaOcupada = this.tiempoOcupado;

        for(let item of buttonsTime){

            for(let datos of horaOcupada){
                if(item.textContent === moment(datos.hora,'HH:mm').format('HH:mm')){
                    let boton = document.getElementById(item.id);
                    boton.hidden = true;
                    break;
                }
            }
        }
    } 

    addEventListenerToButtonsTime(){
        let buttonsTime = this.elTime.querySelectorAll('.horas');
        buttonsTime.forEach(buttonsTime => {
            buttonsTime.addEventListener('click', e => {
                let elTarget = e.target;
                
                if (elTarget.classList.contains('horaSeleccionada')) {
                    
                    return;
                }

                let botonSiguiente = document.getElementById('boton2');
                botonSiguiente.disabled = false; 
                
                let selectedCell = this.elTime.querySelector('.horaSeleccionada');

                if (selectedCell) {
                  
                    selectedCell.classList.remove('horaSeleccionada');
                }

                elTarget.classList.add('horaSeleccionada');
                this.selectedTime = elTarget.textContent;
            });
        });
    }

}
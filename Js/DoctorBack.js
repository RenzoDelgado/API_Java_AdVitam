var p = document.querySelector(".moreinfodoc");

window.onload = pageLoad();

function pageLoad() {
    MostrarAllDocs();
    llenarComboEspecialidad();

    var cboEspecialidad = document.getElementById("cboEspecialidad");

    let valorEspecialidad = cboEspecialidad.value;

    if (valorEspecialidad === "") {
        return;
    }

}

function llenarComboEspecialidad(){
    fetch('http://localhost:8080/AdVitam/listarEspecialidad')
        .then( res => res.json())
        .then( data => {
            template = '<option value="0" selected disabled>Especialidad</option>';
            for(let valor of data){
                template += `<option value="${valor['id']}">${valor['descripcion']}</option>`;
            }
            cboEspecialidad.innerHTML=template;
        });
}


function MostrarDocxEspe() {
    let valorCombo = cboEspecialidad.value;
    var template = "";
    var p = document.getElementById("traer");
    var idsum = "@ID";

    for (var i = 1; i <= idsum; i++) {
        var info = $("#botoninfo_".concat(i));
    }

    var formData = new FormData();

    formData.append("valorCombo", valorCombo);
   // let url="http://localhost:8080/AdVitam/doctorxespecialidad/"+valorCombo;

    fetch(`http://localhost:8080/AdVitam/doctorxespecialidad/${valorCombo}`, {
    })
        .then((res) => res.json())
        .then((data) => {
            for (let valor of data) {
                template += `<div class="profiledoc">
				<img id="imgclick" src="${valor["foto"]}" alt="No hay imagen del doc :(" >

                <button class="activo" type="button" data-bs-toggle="collapse"
                data-bs-target="#multiCollapseExample${valor["id"]}" aria-expanded="false"
                aria-controls="multiCollapseExample${valor["id"]}">Mas informacion</button>
    
                 <div class="collapse multi-collapse" id="multiCollapseExample${valor["id"]}">
                <div class="card moreinfodoc">
                <p class="info_doc">${valor["nombredoctor"] + " " + valor["apellidodoctor"]}</p> 
                <p class="info_doc">Colegiatura: ${valor["nrocolegiatura"]}</p> 
                <p class="info_doc">${valor["universidaddoctor"]}</p> 
                </div>
                 </div>
               
                </div>`;
            }
            p.innerHTML = template;

        });
}

function MostrarAllDocs(){
    let template='';
    let p = document.getElementById("traer");
    fetch('http://localhost:8080/AdVitam/listarDoctor')
        .then( res => res.json())
        .then( data => {
          
            for(let valor of data){
                template += `<div class="profiledoc">
				<img id="imgclick" src="${valor["foto"]}" alt="No hay imagen del doc :(" >

                <button class="activo" type="button" data-bs-toggle="collapse"
                data-bs-target="#multiCollapseExample${valor["id"]}" aria-expanded="false"
                aria-controls="multiCollapseExample${valor["id"]}">Mas informacion</button>
    
                 <div class="collapse multi-collapse" id="multiCollapseExample${valor["id"]}">
                <div class="card moreinfodoc">
                <p class="info_doc">${valor["nombredoctor"] + " " + valor["apellidodoctor"]}</p> 
                <p class="info_doc">Colegiatura: ${valor["nrocolegiatura"]}</p> 
                <p class="info_doc">${valor["universidaddoctor"]}</p> 
                </div>
                 </div>
                </div>`;
            }
            p.innerHTML=template;
        });
}
cboEspecialidad.addEventListener("change", (event) => {
    MostrarDocxEspe();
});


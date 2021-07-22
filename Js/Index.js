window.onload = pageLoad();


function pageLoad() {
    MostrarAllEspecialidad();
}

function MostrarAllEspecialidad(){
    var contador = 0;
    let template='';
    let p = document.getElementById("contespecialidad");
    fetch('http://localhost:8080/AdVitam/listarEspecialidad')
        .then( res => res.json())
        .then( data => {
           
            for(let valor of data){
                contador++;
                template += `
                <div class="specialtyOption ${valor["descripcion"]}">
                <img class="imageOption" src="${valor["imgespecialidad"]}" alt="no hay imagen" />
                <label class="labelOption">${valor["descripcion"]}</label>
                </div>

                `;
                if (contador == 4)
                {
                    break;
                }
            }
            p.innerHTML=template;
            AnimacionEspe();
        });
}


function AnimacionEspe(){
    window.sr = ScrollReveal();

    sr.reveal('.Cardiologia', {
    
        useDelay: 'onload',
        reset: true,
        //interval: 60,
    });
    
    sr.reveal('.Oncologia', {
        duration: 1000,
     useDelay: 'onload',
        reset: true,
        // interval: 60,
    });
    
    sr.reveal('.Ginecologia', {
        duration: 1500,
        useDelay: 'onload',
        reset: true,
        //interval: 60,
    });
    
    sr.reveal('.Pediatria', {
        duration: 2000,
         useDelay: 'onload',
        reset: true,
        // interval: 60,
    });
}
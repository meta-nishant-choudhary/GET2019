function validation() {
    
    var title = document.getElementById('title');
    var description = document.getElementById('description');
    var email = document.getElementById('email');
    var status = document.getElementById('status');
    var creation = document.getElementById('creation');
    var completion = document.getElementById('completion');
    var priority = document.getElementById('priority');
    var forms = document.getElementById('tasks');
   
    if("New" == status.value) {
        if(priority.value == "High") {
            var b1 = document.getElementById('b1');
            b1.style.backgroundColor = "#F77777";
        }
        else if(priority.value == "Low") {
            var b1 = document.getElementById('b1');
            b1.style.backgroundColor = "#F1F49D";
        }
        else if(priority.value == "Medium") {
            var b1 = document.getElementById('b1');
            b1.style.backgroundColor = "#83FE93";
        }
        
        document.getElementById('title1').innerHTML = title.value;
        document.getElementById('desc1').innerHTML = description.value;
        
    }
    else if("Progress" == status.value) {
        if(priority.value == "High") {
            var b1 = document.getElementById('b1');
            b2.style.backgroundColor = "#F77777"; //red
        }
        else if(priority.value == "Low") {
            var b1 = document.getElementById('b1');
            b2.style.backgroundColor = "#F1F49D"; //yellow
        }
        else if(priority.value == "Medium") {
            var b1 = document.getElementById('b1');
            b2.style.backgroundColor = "#83FE93";
        }
        document.getElementById('title2').innerHTML = title.value;
        document.getElementById('desc2').innerHTML = description.value;
    }
    else if("Completed" == status.value) {
        if(priority.value == "High") {
            var b1 = document.getElementById('b1');
            b3.style.backgroundColor = "#F77777";
        }
        else if(priority.value == "Low") {
            var b1 = document.getElementById('b1');
            b3.style.backgroundColor = "#F1F49D";
        }
        else if(priority.value == "Medium") {
            var b1 = document.getElementById('b1');
            b3.style.backgroundColor = "#83FE93";
        }
        document.getElementById('title3').innerHTML = title.value;
        document.getElementById('desc3').innerHTML = description.value;

    }
    else { return false; }
    document.getElementById('tasks').style.display = "block";
    document.getElementById('form').style.display = "none";
    return true;
}
function showForm() {
    document.getElementById('form').style.display = "block";
    document.getElementById('tasks').style.display = "block";
}
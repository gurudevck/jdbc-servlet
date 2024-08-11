function validateStudent(e){
    e.preventDefault()
    let id = document.getElementById('studentId').value
    let name = document.getElementById('studentName').value
    let flag=true

    if(isNaN(id) || id<0 || id>100){
        flag=false
        document.getElementById("iderror").innerHTML = "enter numbers between 0 and 100"
    }
    else{
        document.getElementById("iderror").innerHTML = ""
    }

    if(!/^[a-zA-Z]+$/.test(name)){
        flag=false
        document.getElementById("nameerror").innerHTML = "enter string only"
    }
    else{
        //document.getElementById("iderror").innerHTML = ""
        
    }
}
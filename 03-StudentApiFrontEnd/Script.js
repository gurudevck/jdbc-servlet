function addStudent(){
    //alert("added")
    let studentId = document.getElementById("studentId").value
    let studentName = document.getElementById("studentName").value
    let studentScore = document.getElementById("studentScore").value

    let data = "studentId="+studentId+"&studentName="+studentName+"&studentScore="+studentScore

    let xhr = new XMLHttpRequest()
    xhr.open("POST", "http://localhost:9091/StudentApi/StudentApiServlet", true)
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            alert(xhr.responseText)
            let response = JSON.parse(xhr.responseText)
            //add to ui
            getStudents();
        }
    }
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.send(data)
}

function getStudents(){
    let xhr = new XMLHttpRequest()
    xhr.open("GET", "http://localhost:9091/StudentApi/StudentApiServlet",true)
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            alert(xhr.responseText)
        }
    }
    xhr.send()
}
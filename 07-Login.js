function validateForm(e){
    //e.preventDefault();
    //alert("submitted");   
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let flag=true

    if(username===""){
        flag=false;
        document.getElementById("usernameError").innerHTML = "username required"
    } else {
        document.getElementById("usernameError").innerHTML = ""
    }
    if(password === ""){
        flag=false;
        document.getElementById("passwordError").innerHTML = "password required"
    } else {
        document.getElementById("passwordError").innerHTML = ""
    }
    if(flag){
        sessionStorage.setItem("username",username)
        document.getElementById("loginForm").onsubmit()
        // document.getElementById("success").innerHTML = "submmited as "+username+" and password is "+password
    }
}
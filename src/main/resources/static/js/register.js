var registerButton = document.getElementById("registerButton");

function checkToRegister(event) {
    var login = document.getElementById("r_login").value;
    var password1 = document.getElementById("r_password1").value;
    var password2 = document.getElementById("r_password2").value;
    var email = document.getElementById("r_email").value;

    if (!checkLogin(login) || !checkPassword(password1, password2) || !checkEmail(email)) {
        event.preventDefault();
    }
}

function checkLogin(login) {
    if (login !== "") {
        if (!(/^\d/.test(login))) {
            if(login.length >= 8) {
                return true;
            }
            else {
                alert("Длина логина должна составлять не менее 8 символов");
                return false;
            }
        } else {
            alert("Логин не может начинаться с цифры");
            return false;
        }
    } else {
        alert("Поле логина не должно быть пустым");
        return false;
    }
}

function checkPassword(password1, password2) {
    if (password1 !== "" && password2 !== "") {
        if (password1 === password2) {
            if(password1.length >= 8) {
                return true;
            }
            else {
                alert("Длина пароля должна быть не менее 8 символов");
                return false;
            }
        } else {
            alert("Пароли не совпадают");
            return false;
        }
    } else {
        alert("Пароль не может быть пустым");
        return false;
    }
}

function checkEmail(email) {
    if (email !== "") {
        if (email.includes("@")) {
            return true;
        } else {
            alert("Неверный формат email");
            return false;
        }
    } else {
        alert("Email не может быть пустым");
        return false;
    }
}

registerButton.addEventListener("click", checkToRegister);

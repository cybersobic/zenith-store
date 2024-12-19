var registerButton = document.getElementById("registerButton");

function checkToRegister(event) {
    var login = document.getElementById("r_login").value;
    var password1 = document.getElementById("r_password1").value;
    var password2 = document.getElementById("r_password2").value;
    var phoneNumber = document.getElementById("r_phoneNumber").value;
    var email = document.getElementById("r_email").value;
    var firstName = document.getElementById("r_first_name").value;
    var lastName = document.getElementById("r_last_name").value;
    var company = document.getElementById("r_company").value;

    if (!checkLogin(login) || !checkPassword(password1, password2) ||
    !checkPhoneNumber(phoneNumber) || !checkEmail(email) || !checkAnyName(firstName) ||
    !checkAnyName(lastName) || !checkCompany(company)) {
        event.preventDefault();
    }
}

function checkLogin(login) {
    if (login !== "") {
        if (!(/^\d/.test(login))) {
            if(login.length >= 8 && login.length <= 24) {
                if(!(/\s/.test(login))) {
                    return true;
                }
                else {
                    alert("Логин не должен содержать пробелы");
                    return false;
                }
            }
            else {
                alert("Длина логина должна составлять от 8 до 24 символов");
                return false;
            }
        } 
        else {
            alert("Логин не может начинаться с цифры");
            return false;
        }
    } 
    else {
        alert("Поле логина не должно быть пустым");
        return false;
    }
}

function checkPassword(password1, password2) {
    if (password1 !== "" && password2 !== "") {
        if (password1 === password2) {
            if(password1.length < 8) {
                alert("Длина пароля должна быть более 8 символов");
                return false;
            }
            else if(password1.length > 64) {
                alert("Длина пароля может быть до 64 символов");
                return false;
            }
            else {
                if(password1[0] === " ") {
                    alert("Пароль не должен начинаться с пробела");
                    return false;
                }                
                else if(password1[password1.length - 1] === " ") {
                    alert("Пароль не должен заканчиваться пробелом");
                    return false;
                }
                else {
                    return true;
                }
            }
        } 
        else {
            alert("Пароли не совпадают");
            return false;
        }
    } 
    else {
        alert("Пароль не может быть пустым");
        return false;
    }
}

function checkPhoneNumber(phoneNumber) {
    const phonePattern = /^\+[0-9]{11,14}$/; 

    if (phoneNumber !== "") {
        if (phonePattern.test(phoneNumber)) {
            return true;
        }
        else {
            alert("Неверный формат номера телефона");
            return false;
        }
    }
    else {
        alert("Номер телефона не может быть пустым");
        return false;
    }
}

function checkEmail(email) {
    const emailPattern = /^(([^<>()[\].,;:\s@"]+(\.[^<>()[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/iu;

    if (email !== "") {
        if (emailPattern.test(email)) {
            return true;
        } 
        else {
            alert("Неверный формат email");
            return false;
        }
    } 
    else {
        alert("Email не может быть пустым");
        return false;
    }
}

function checkAnyName(anyName) {
    if(anyName !== "") {
        const namePattern = /^[А-ЯЁ][а-яё]{1,34}$/;

        if(namePattern.test(anyName)) {
            return true;
        }
        else {
            alert("Неверный формат имени или фамилии");
            return false;
        }   
    }
    else {
        return true;
    }
}

function checkCompany(company) {
    if(company !== "") {
        if(company.length >= 2 && company.length <= 50) {
            if(company[0] === " ") {
                alert("В начале названия компании есть пробел");
                return false;
            }
            else if(company[company.length - 1] === " ") {
                alert("В конце названия компании есть пробел");
                return false;
            }
            else {
                return true;
            }
        }
        else {
            alert("Название компании может быть от 2 до 50 символов");
            return false;
        }
    }
    else {
        return true;
    }
}

registerButton.addEventListener("click", checkToRegister);
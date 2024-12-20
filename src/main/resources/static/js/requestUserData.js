async function requestUserData(token, sub) {
    try {
        const response = await fetch(`/login/getUserData?login=${sub}`, {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok) {
            throw new Error('Ошибка при получении данных пользователя');
        }

        const userData = await response.json();

        outputData(userData);
    }
    catch (error) {
        console.error('Ошибка:', error);
        return null;
    }
}

function parseJwt(token) {
    var base64Url = token.split('.')[1];

    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');

    var payload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(payload);
}

function outputData(userData) {
    const accountInfoDiv = document.getElementById("accInfo");

    accountInfoDiv.innerHTML = `
        <p><span>Логин: </span>${userData.login}</p></br>
        <p><span>Адрес электронной почты: </span>${userData.email}</p></br>
        <p><span>Номер телефона: </span>${userData.phoneNumber}</p></br>
        <p><span>Имя: </span>${userData.firstName}</p></br>
        <p><span>Фамилия: </span>${userData.lastName}</p></br>
        <p><span>Название организации: </span>${userData.company}</p>
    `;
}

const token = localStorage.getItem('token');

if(token !== null) {
    const parsedToken = parseJwt(token);
    requestUserData(token, parsedToken.sub);
}
else {
    window.location.href = "/login";
}
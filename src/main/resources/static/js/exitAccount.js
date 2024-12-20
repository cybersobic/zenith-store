function exitAccount() {
    if (window.confirm("Вы действительно хотите выйти из аккаунта?")) {
        const token = localStorage.getItem("token");

        localStorage.removeItem("token");

        window.location.href = "/";
    }
}

const exitButton = document.getElementById("exitButton");

exitButton.addEventListener("click", exitAccount);
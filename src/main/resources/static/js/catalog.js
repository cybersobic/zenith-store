// Изначально выделяем первую категорию
var categoriesList = document.getElementsByClassName("category");
selectCategory(categoriesList[0]);

// Добавление обработчика событий на каждую категорию
for (let i = 0; i < categoriesList.length; i++) {
    categoriesList[i].addEventListener("click", function() {
        resetCategories();
        selectCategory(categoriesList[i]);
    });
}

// Функция для выделения категории
function selectCategory(category) {
    category.style.backgroundColor = "#6F8081";
    category.style.color = "white";
}

// Функция для сброса стилей всех категорий
function resetCategories() {
    for (let i = 0; i < categoriesList.length; i++) {
        categoriesList[i].style.backgroundColor = "";
        categoriesList[i].style.color = "";
    }
}

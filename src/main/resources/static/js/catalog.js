// Изначально выделяем первую категорию
var categoriesList = document.getElementsByClassName("category");
selectCategory(categoriesList[0]);

// Изначальный вывод всех товаров
requestProducts(0);

// Обработчик события нажатия на каждую категорию
for (let i = 0; i < categoriesList.length; i++) 
{
    // Обработчики нажатий по категориям
    categoriesList[i].addEventListener("click", function() 
    {
        resetCategories();
        selectCategory(categoriesList[i]);
        requestProducts(i);
    });
}

// Функция для выделения категории
function selectCategory(category)
{
    category.style.backgroundColor = "#637273";
    category.style.color = "white";
}

// Функция для сброса стилей всех категорий
function resetCategories() 
{
    for (let i = 0; i < categoriesList.length; i++) 
    {
        categoriesList[i].style.backgroundColor = "";
        categoriesList[i].style.color = "";
    }
}

// Функция запроса товаров по выбранной категории
async function requestProducts(i)
{
    try
    {
        console.log(`Передаваемый ID: ${i}`);

        const response = await fetch(`/catalog/products?categoryId=${i}`, 
        {
            method: 'GET',
            headers: 
            {
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok)
        {
            throw new Error('Ошибка при получении данных о товарах');
        }

        const products = await response.json();

        console.log(products);

        const productContainer = document.getElementById("productListContainer");
        
        productContainer.innerHTML = '';

        products.forEach(product => 
        {
            const productElement = document.createElement('div');
            
            productElement.classList.add('prods');
            
            productElement.innerHTML = `
                <div class="product_image">
                    <img src="images/product_default_image.png" alt="product_default_image">
                </div>
                <div class="product_content">
                    <a href="#" class="product_name">${product.name}</a><br>
                    <p class="product_price">${product.price} руб.</p><br>
                </div>
                <div class="product_menu">
                    <a class="buy_product" href="/buy">Купить</a>
                </div>
            `;

            productContainer.appendChild(productElement);
        });
    } 
    catch (error)
    {
        console.error('Ошибка:', error);
        return null;
    }
}
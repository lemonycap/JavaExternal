# JavaExternal

## Task 1
Игровая JAVA – программа, которая отгадывает число по принципу – «больше – меньше».

### Application architecture built with
  MVC pattern

### App localization
  * English
  * Russian
  
## Task 2
Figures. 


### Link to the project
https://github.com/Berehulia/ShapesExercise

## Task 3
Droid wars.

### Link to the project
https://github.com/Berehulia/DroidWars

## Task 4
Реализовать поисковый сервис Shakespeare. По указанному слову вывести список URL, упорядоченным по частоте возрастания слова.

### Solution
Вначале формируется словарь из всех доступных слов по 10 URL, взятым с сайта http://shakespeare.mit.edu/. После формирования словаря, подсчитывается частота каждого слова на каждой ссылке и сохраняется в контейнер HashMap (если слово не встречается на некотором URL,то пара "URL - нулевая частота" не записывается в контейнер).
Пользователю показывается полный словарь в виде "порядковый номер - слово" и предлагается ввести номер слова, для которого необходимо получить результат. В результате пользователь получает ответ, сформированый в формате "URL - частота слова на данном URL".


 ## Task 5
 Реализовать Weather Station с помощью паттерна Наблюдатель.
 При выполнении работы были использованы библиотеки для работы с JSON форматом.
 
 ## Task 6
  * Создать файл XML и соответствующую ему схему XSD.
  * При разработке XSD использовать простые и комплексные типы, перечисления, шаблоны и предельные значения.
  * Сгенерировать класс, соответствующий данному описанию.
  * Создать приложение для разбора XML-документа и инициализации коллекции объектов информацией из XML-файла. Для разбора использовать  SAX, DOM и StAX парсеры. Для сортировки объектов использовать интерфейс Comparator.
  * Произвести проверку XML-документа с привлечением XSD.
  * Определить метод, производящий преобразование разработанного XML-документа в документ, указанный в каждом задании.
  
  ### Individual task
  9. Конфеты.
  * Name — название конфеты;
  * Energy — калорийность (ккал);
  * Type (должно быть несколько) — тип конфеты (карамель, ирис, шоколадная [с начинкой либо нет]);
  * Ingredients (должно быть несколько) — ингредиенты: вода, сахар (в мг),фруктоза (в мг), тип шоколада (для шоколадных), ванилин (в
  мг);
  * Value — пищевая ценность: белки (в г), жиры (в г) и углеводы (в г);
  * Production — предприятие-изготовитель.
  * Корневой элемент назвать Candy.
  * С помощью XSL преобразовать XML-файл в формат HTML, при выводе отсортировать по месту изготовления.
  
  ## Task 8
  Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент в порту и на корабле, должно быть неотрицательным и превышающим заданную грузоподъемность судна и вместимость порта. В порту работает несколько причалов. У одного причала может стоять один корабль. Корабль может загружаться у причала, разгружаться или выполнять оба действия.
  
  ### Versions 
  * v 0.1 - реализация задания с использованием ключевого слова "synchronized"
  
 
  
  

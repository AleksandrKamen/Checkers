#                                                              Обзор проекта (Checkers)
<p align="center"> <img width="600" height="600" src="https://github.com/AleksandrKamen/Checkers/blob/master/Demo/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA.PNG"> </p>

**Мотивация проекта** - Демонстрация принципов дизайна архитектуры приложения с помощью ООП, использование Gradle для сборки проекта, применение Junit5 для проведения тестов.

**Суть проекта** – Консольная реализация игры – Шашки, с использованием  стандартных правил.

#                                                        Пользовательский интерфейс  и возможности 
 **Взаимодействие с пользователем реализовано через выбор ячейки.  Доступные для выбора шашки подсвечиваются желтым цветом.** 
                                  ![Image alt](https://github.com/AleksandrKamen/Checkers/blob/master/Demo/1.PNG)  
                                  
 **При доступном для атаки ходе, он является обязательным. После выбора ячейки, зеленым подсвечиваются доступные варианты, красным – уничтожаемые шашки противника**   
                                 ![Image alt](https://github.com/AleksandrKamen/Checkers/blob/master/Demo/2.PNG)  
                                 
 **Если после уничтожения вражеской шашки доступно еще одно уничтожение – ход продолжается.**
                                  ![Image alt](https://github.com/AleksandrKamen/Checkers/blob/master/Demo/3.PNG)  
                                   
**При достижении шашкой границы поля – она превращается в дамку.**
                                   ![Image alt](https://github.com/AleksandrKamen/Checkers/blob/master/Demo/4.PNG) 
                                   
 **При уничтожении всех вражеских фигур – игра заканчивается. Игровой цикл предлагается повторить заново.**
                                  ![Image alt](https://github.com/AleksandrKamen/Checkers/blob/master/Demo/Снимок7.PNG) 

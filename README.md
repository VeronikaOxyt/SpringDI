# Spring DI (task The enrollment in the university)
<h2 align="center">Инструкции к запуску</h2>
<h3>Класс AppA</h3>
Запустит вариант конфигурации a: 
Xml: Использовать <bean> (для студентов), @Component с <components-scan> для
преподавателя
<h3>Класс AppB</h3>
Запустит вариант конфигурации b:
Java: (@Configuration, @Bean (для студентов), @Component с @ComponentScan для
преподавателя)
<hr>
<br/>
Добавлены флаг зачисления студента и BeanPostProcessor

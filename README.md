Reporte Laboratorio 9

Ronald Catún - 19789
Julio Pellecer - 24714
Angel Armas - 241071


1. Reflexión
   El ViewModel da una solución al problema planteado en la Parte 1, gracias
   a que su ciclo de vida es distinto y, sobre todo, más largo que el de una
   Activity. A diferencia de una Activity, que se reinicia por completo cuando
   hay cambios en la configuración, como al girar la pantalla, el ViewModel se
   mantiene en pie y guarda su información tal cual. En otras palabras, al rotar
   la pantalla, la Activity y sus elementos se van, pero el ViewModel sigue ahí,
   con   todos sus    datos a salvo. Así, la   nueva Activity puede recuperar todo
   justo como estaba antes. Dentro de este contexto, la "única fuente de verdad" quiere
   decir que el ViewModel funciona como el archivo principal y fidedigno de cada dato de
   la interfaz de usuario.
   En vez de tener diversos sitios   donde la información se guarda y cambia (algo que pro-
   vocaría fallos), cada detalle importante vive solo en el ViewModel y de ahí se transmite
   a la UI. Esto asegura que   sin importar las veces que se rehaga la interfaz o se vuelva
   a crear la Activity, siempre  habrá una referencia segura de la situación presente de la
   app, evitando probables errores entre distintas secciones de la UI.
   
   StateFlow echa una mano manteniendo   el estado, gracias a un método reactivo y que se puede
   observar, el cual suelta el estado en el que estamos   y cada cambio que venga después, todo
   esto sin problemas con los hilos thread-safe. A diferencia de una variable mutable normal,
   StateFlow avisa en automático a todos los que están mirando cuando el estado cambia, lo que
   le da chance a la UI de ponerse al día de manera reactiva sin que tengamos que andar refrescando
   a mano. Encima de todo, StateFlow siempre tiene un valor desde el principio y se asegura de que
   los nuevos que se unan a observar reciban de inmediato el estado más nuevo, así la UI siempre
   muestra lo que está pasando en el ViewModel, sin importar cuándo se suscriban.
   Cuando deslindamos la lógica de la interfaz de usuario de la lógica empresarial, cosechamos
   un montón de beneficios importantes. Para empezar, el código se vuelve mucho más fácil de
   probar, porque podemos poner a prueba la lógica empresarial en el ViewModel por su cuenta, sin
   tener que andar creando componentes de IU o Activities. En segundo lugar, el mantenimiento del
   código mejora bastante al tener tareas bien delimitadas: la IU se centra únicamente en mostrar elementos
   y pillar eventos del usuario, mientras que el ViewModel se encarga de toda la lógica y los cambios en los
   datos. Por otro lado, facilita la reutilización del código, posibilitando que usemos la misma lógica
   empresarial en distintas pantallas o incluso en plataformas diferentes. Por último, esta separación hace
   que el código aguante mejor los cambios en el ciclo de vida de Android, ya que la lógica más
   importante reside en el ViewModel, que no depende de las reconstrucciones de la IU.
   

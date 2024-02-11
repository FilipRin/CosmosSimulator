# CosmosSimulatorGame
------------------------
"Endless runner" type game, where we control spacecraft. Goal is to avoid comets (which destroys you) and explore planets (which grant additional points) and survive as long as you can!

ENG

• *An object in space or objekat* is created with given integer coordinates of the center in two-dimensional space, which can also be retrieved by color (Color). It is possible to individually change each of the coordinates of the center for the given displacement. It is possible to draw an object in space over a given graphics context (Graphics).

• *A celestial body or nebesko telo* is an object in space that is created with an additionally specified radius of the described circle in pixels.

• *A comet or kometa* is a gray celestial body. The comet is drawn around the center as a regular pentagon with random orientation.

• *A planet or planeta* is a celestial body that spawns with one of the following colors: GREEN, BLUE, YELLOW, or RED, each with a 25% chance. Additionally, a planet may contain a ring with a 25% probability. The planet is drawn as a circle around the center of the given color. If it contains a ring, it is drawn as a circle around the same center with twice the radius.

• *The spacecraft or letelica* is a CYAN object which is additionally created with length of the base and height as parameters. It can be checked if the spacecraft overlaps with another celestial body. It overlaps if the radius of the described circle is less than the sum of half the base and the height. The aircraft is drawn around the center as an triangle.

• *The universe or svemir* is an active canvas (Canvas) with a black background that contains an arbitrary number of celestial bodies. It is possible to add a celestial body. Every 100 milliseconds, space plots all contained celestial bodies, then simulates movement through space by shifting the y-coordinate of all celestial bodies by 5 pixels. It is possible to start and permanently end space activity.

• *An active celestial body generator or aktivni generator nebeskih tela* is created with a given universe. Every 900 milliseconds, the generator creates a comet whose x-coordinate of the center is a random value between 0 and 200, y-coordinate of the center is 0, and the radius of the described circle is a random value between 10 and 30, and then adds it to space. It is possible to start and permanently end a generator activity.

• *The simulator* is the main application window 200 pixels wide by 400 pixels high that contains the universe, a command panel, and a celestial body generator. The command panel contains a button labeled "Run!". Pressing the "Launch!" button starts the universe and celestial body generator, after which the button is disabled.

--------------------------
SRB

• *Објекат у свемиру* се ствара са задатим целобројним координатама центра у дводимензионалном
простору које могу да се дохвате и бојом (Color). Могуће је појединачно променити сваку од
координата центра за задати померај. Могуће је исцртати објекат у свемиру над задатим
графичким контекстом (Graphics).

• *Небеско тело* је објекат у свемиру који се ствара са додатно задатим полупречником описане
кружнице у пикселима.

• *Комета* је небеско тело сиве боје (GRAY). Комета се око центра
исцртава као правилни петоугао са насумичном оријентацијом.

• *Планета* је небеско тело које се ствара са једном од следећих боја: зелена, плава, жута или црвена, свака са 25% вероватноће. Додатно планета може садржати прстен са 25% вероватноће. Планета се ицртава као круг око центра задате боје. Уколико садржи прстен, он се исцртава као кружница око истог центра дупло већег полупречника.

• *Летелица* је објекат светло плаве боје који се додатно ствара дужином основице и висином. Може се проверити да ли се летелица преклапа са другим небеским телом. Преклапа се уколико је полупречник описане кружнице мањи од збира половине основице и висине. Летелица се исцртава око центра као троугао.

• *Свемир* је активно платно (Canvas) са црном позадином
које садржи произвољан број небеских тела. Могуће је додати
небеско тело. На сваких 100 милисекунди, свемир исцртава сва
садржана небеска тела, а потом симулира кретање кроз свемир тако
што свим небеским телима помера y-координату за 5 пиксела.
Могуће је покренути и трајно завршити активност свемира.

• *Активни генератор небеских тела* се ствара са задатим свемиром. На
сваких 900 милисекунди, генератор прави комету чија је xкоордината центра насумична вредност између 0 и 200, y-координата
центра 0, а полупречник описане кружнице насумична вредност
између 10 и 30, а потом је додаје у свемир. Могуће је покренути и
трајно завршити активност генератора.

• *Симулатор* је главни прозор апликације ширине 200 и висине 400
пиксела који садржи свемир, панел са командама и генератор
небеских тела. Панел са командама садржи дугме са натписом
„Pokreni!“. Притиском на дугме „Pokreni!“ покрећу се свемир и
генератор небеских тела, након чега је дугме онемогућено.

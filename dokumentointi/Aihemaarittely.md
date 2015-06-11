##Aihemäärittely

Tämän työn tavoitteena on ohjelmoida shakkipeli. Siinä ei ole tekoälyä, vaan sitä on pelattava kahden pelaajan voimin saman tietokoneen ääressä.

Valmiissa ohjelmassa tulee olemaan graafinen käyttöliittymä, joka piirtää pelilaudan ruudulle. Nappuloita siirrellään vuorotellen laudalla klikkailemalla. Ohjelman logiikka estää väärät siirrot ja huijaamisen. Käyttäjä ei kirjoita ohjelmaan muuta kuin oman nimerkkinsä ennen pelin alkua. Ohjelma tunnistaa shakki-tilanteen. Silloin shakissa oleva pelaaja pystyy tekemään vain siirtoja, joilla shakkitilanne poistetaan. Peli ei pysty tunnistamaan shakkimattia. Tällöin kaikki pelaaja huomaa, että kaikki hänen siirtonsa ovat laittomia, joten ainoaksi mahdollisuudeksi tulee pelin päättäminen painamalla Give up-painiketta.

Ohjelmassa ei ole mukana hieman harvinaisempia tilanteita kuten linnottautuminen, sotilaan ylentäminen tai ohestalyönti.

Alustavana tavoitteena on saada aikaan toimiva ohjelma, jossa nappuloiden siirto onnistuu shakin sääntöjen mukaan. Jos aikaa jää, on tavoitteena saada aikaan myös kesken jääneen pelin tallentaminen ja lataaminen myöhemmin.

**Käyttäjät:** shakin ystävät.

**Käyttäjän toiminnot:**
- nimimerkin kirjoittaminen pelin alussa
- nappuloiden siirtäminen
- pelitilanteen tallentaminen
- viimeisen tallennetun pelin lataaminen
- tarvittaessa pelin resetoiminen
- luovuttaminen kun tulee shakkimatti

System simuluje jednoduchy counter pre pocet 
prihlaseni nejakeho uzivatela.

Jax-RS pre jednoduchost akceptuje len json,
format, chcel som sa vyhnut nejakym zbytocnym ozdobam.
Takto existuje iba jedna entita ktora sa da pouzit na persistenciu
aj pre rest request a nema privela ozdob.

Testoval som s arquillianom na remote jboss 7.1.
Zobral som stade aj testovaci datasource pre fiktivne ulozenie.

Message Queue je tiez vytvorena na jbosse, pouzil som len jednu, 
default testovaciu co na jboss existuje v konfiguracii, na tieto
ucely postacuje.

Mame jeden testovaci scenar, co akceptuje pri pozadovanom
http navratovom kode.

Ospravedlnujem sa za Deprecated metody, najskor som tam mal nizsiu
verziu jaxrs. Nakoniec som to uz nehal tak, bolo by potrebne vymenit
za hocakeho ineho http klienta.



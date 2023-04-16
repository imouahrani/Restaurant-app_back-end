# Restaurant-app
## Get restaurants
![1-restaurants.PNG](1-restaurants.PNG)
# Get menus
![2-getMenus.PNG](2-getMenus.PNG)
# Get list menus of a restaurant
![3-getlisteMenus.PNG](3-getlisteMenus.PNG)
# Get menus of one restaurant
![getMunusOfOneRestaurant.PNG](getMunusOfOneRestaurant.PNG)

# Requêtes SQL H2 DB
INSERT INTO MENUS(IDENTIFIANT,ENTREES, PLATS, DESSERTS)VALUES('menu01','testadressemenu', 'testnommenu', 'testplatmenu');
INSERT INTO RESTAURANT_MENUS (RESTAURANT_ID , MENUS_IDENTIFIANT)VALUES('resto1','menu01');
INSERT INTO RESTAURANT (ID, ADRESSE, NOM)VALUES('resto1', 'testadresseresto', 'testnomresto');

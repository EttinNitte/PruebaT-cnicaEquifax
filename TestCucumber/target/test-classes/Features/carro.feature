#Author: Eduardo Cea
#Email: edu.cea20@gmail.com

Feature: Pruebas de buscador de productos
  
  Scenario: Probar busqueda por tipo de producto
    Given navego a la URL "http://advantageonlineshopping.com/#/"   
    When se selecciona el icono de busqueda
    And se ingresa "Laptops"
    And se presiona el boton buscar
    Then el sistema muestra los productos relacionados a "HP CHROMEBOOK 14 G1(ENERGY STAR)"

   Scenario: Probar busqueda por marca de producto
   	Given navego a la URL "http://advantageonlineshopping.com/#/"
    When se selecciona el icono de busqueda
    And se ingresa "HP"
    And se presiona el boton buscar
    Then el sistema muestra los productos relacionados a "HP CHROMEBOOK 14 G1(ENERGY STAR)"
    
   Scenario: Probar busqueda sin resultados
    Given navego a la URL "http://advantageonlineshopping.com/#/"
    When se selecciona el icono de busqueda
    And se ingresa "Audifono"
    And se presiona el boton buscar
    Then el sistema no encuentra resultados para "Audifono"
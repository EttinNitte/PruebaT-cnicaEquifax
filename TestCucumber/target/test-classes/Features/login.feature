#Author: Eduardo Cea
#Email: edu.cea20@gmail.com

Feature: Pruebas de login de usuario

  Scenario: login correcto
    Given navego a la URL "http://advantageonlineshopping.com/#/"
    When el usuario selecciona el boton de perfil de usuario para iniciar sesion
    And Ingresa el usuario "BPearson"
    And la password "BPearson1"
    Then el sistema logea correctamente al usuario "BPearson"

   Scenario: login incorrecto
   	Given navego a la URL "http://advantageonlineshopping.com/#/"
    When el usuario selecciona el boton de perfil de usuario para iniciar sesion
    And Ingresa el usuario "chask"
    And la password "callefalsa123"
    Then el sistema  no logea al usuario
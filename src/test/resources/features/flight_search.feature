  # Authors: Jose, Miguel, Juan Carlos
    # Language: es

    # src/test/resources/features/compra_vuelos.feature
  Feature: Proceso de compra de un vuelo
    Como viajero
    Quiero realizar una búsqueda, selección y compra de un vuelo
    Para completar exitosamente mi proceso de reserva

    Scenario: Buscar vuelos disponibles entre dos ciudades
      Given que accedo al sistema de reservas
      When indico la ciudad de origen "Boston" y destino "London"
      And solicito la busqueda del vuelo
      Then veo las alternativas de vuelos disponibles
      And visualizo los detalles de los vuelos

    Scenario: Seleccionar una opción de vuelo
      Given que observo las alternativas de vuelos disponibles
      When elijo una opcion de vuelo
      Then veo que mi vuelo ha sido reservado
      And visualizo el formulario de compra

    Scenario: Ingresar la información necesaria para completar la compra
      Given que visualizo el formulario de compra
      When suministro la informacion requerida para la compra
      And compro el vuelo
      Then veo un resumen de los detalles del vuelo


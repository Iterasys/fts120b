$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DaConsultaAoCarrinho_Cucumber.feature");
formatter.feature({
  "line": 1,
  "name": "ConsultaCompra",
  "description": "Usu�rios\r\nPatricia � uma cliente frequente\r\nWagner � um visitante eventual",
  "id": "consultacompra",
  "keyword": "Feature"
});
formatter.before({
  "duration": 27078782256,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Caminho Feliz",
  "description": "",
  "id": "consultacompra;caminho-feliz",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "que acesso o site Submarino",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "pesquiso por \"smartphone\" e pressiona Enter",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "exibe a lista de produtos relacionados com \"smartphone\"",
  "keyword": "Then "
});
formatter.match({
  "location": "DaConsultaAoCarrinho_Cucumber.que_acesso_o_site_Walmart()"
});
formatter.result({
  "duration": 28162232168,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "smartphone",
      "offset": 14
    }
  ],
  "location": "DaConsultaAoCarrinho_Cucumber.pesquiso_por_e_pressiona_Enter(String)"
});
formatter.result({
  "duration": 20243624264,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "smartphone",
      "offset": 44
    }
  ],
  "location": "DaConsultaAoCarrinho_Cucumber.exibe_a_lista_de_produtos_relacionados_com(String)"
});
formatter.result({
  "duration": 579711294,
  "status": "passed"
});
formatter.after({
  "duration": 3101898515,
  "status": "passed"
});
});
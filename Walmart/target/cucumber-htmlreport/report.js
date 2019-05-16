$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DaConsultaAoCarrinho_Cucumber.feature");
formatter.feature({
  "line": 1,
  "name": "ConsultaCompra",
  "description": "Usu�rios\r\nPatricia � uma cliente frequente\r\nWagner � um visitante eventual",
  "id": "consultacompra",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6390104197,
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
  "duration": 21707856637,
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
  "duration": 13598850416,
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
  "duration": 708209675,
  "status": "passed"
});
formatter.after({
  "duration": 1364536655,
  "status": "passed"
});
});
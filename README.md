# GitAliasDetector
Heuristica para detecção de alias em usuarios git.
 
# Alias
Usuários Github podem ter mais de uma conta, com nomes e e-mails diferentes. Alias são essas várias contas de uma mesma pessoa.

# Funcionamento
Para a detecção de alias, o sistema clona um repositório do git, buscar todos os usuários que já executaram commit nesse repositório e procura dentre esses usuários os possiveis alias.

# Heurística Proposta
A heuristica proposta para a detecção de alias, possui as seguintes definiçes:

 - E-mail: E-mail completo de um usuário, ex.: artur@gmail.com
 - Nome: Nome completo de um usuário, ex.: Artur Costa Ventura
 - SubNome: Palavras que constituem o nome, ex.: Artur ou Costa ou Ventura
 - Prefixo: Parte do e-mail antes do @, ex.: artur
 - Similaridade: Para similaridade foi utilizado o algorítimo Jaro-Winkler, que é uma variação da métrica Damerau-Levenshtein, onde leva em consideração que uma substituição de caracteres próximos é menos importante que caracteres distantes. A heuristica leva em consideração o número de correlações, número de transposições e o tamanho das string.

1. Verifica se os e-mails forem iguais 

    - Em caso positivo considera alias
    
2. Caso nome possua similaridade maior que 0.9

  2.1. Verificar se os prefixos são igual
  
    - Em caso positivo considera alias
    
  2.2. Verifica se o prefixo possui similaridade com o Nome ou com algum SubNome maior que 0.95
  
    - Em caso positivo considera alias
    
# Como Utilizar
Para utilizar deve executar o arquivo AliasDetector.java passando como parametro a URL do repositório.
O algoritmo irá executar a rotina e produzir como saida a lista de Alias encontrados no repositório.

# Exemplo
  - Entrada: https://github.com/angular/angular.js
  - Saida:
  
Nome do Alias: Martin

	Nome: Martin Staffa
	E-mail: mjstaffa@gmail.com

	Nome: Martin Staffa
	E-mail: mjstaffa@googlemail.com

	Nome: Narretz
	E-mail: mjstaffa@googlemail.com


Nome do Alias: Frederik

	Nome: frederikprijck
	E-mail: frederik.prijck@gmail.com

	Nome: Frederik Prijck
	E-mail: frederik.prijck@gmail.com

	Nome: PRIJCK Frederik (FPRJ)
	E-mail: frederik.prijck@gmail.com


Nome do Alias: PatrickJS

	Nome: gdi2290
	E-mail: github@gdi2290.com

	Nome: PatrickJS
	E-mail: github@gdi2290.com


Nome do Alias: Pete

	Nome: Peter Bacon Darwin
	E-mail: pete@bacondarwin.com

	Nome: Pete Bacon Darwin
	E-mail: pete@bacondarwin.com


Nome do Alias: Michał

	Nome: Michał Gołębiowski
	E-mail: m.goleb@gmail.com

	Nome: Michał Gołębiowski
	E-mail: m.goleb@gmail.com


Nome do Alias: Lucas

	Nome: Lucas Mirelmann
	E-mail: lgalfaso@gmail.com

	Nome: Lucas Galfaso
	E-mail: lgalfaso@gmail.com

	Nome: Lucas Galfasó
	E-mail: lgalfaso@gmail.com


Nome do Alias: thorn0

	Nome: Georgii Dolzhykov
	E-mail: thorn.mailbox@gmail.com

	Nome: thorn0
	E-mail: thorn.mailbox@gmail.com

	Nome: Georgii
	E-mail: thorn.mailbox@gmail.com


Nome do Alias: spaceribs

	Nome: Aaron Brewer
	E-mail: spaceribs@gmail.com

	Nome: spaceribs
	E-mail: spaceribs@gmail.com


Nome do Alias: JonyD

	Nome: Joao Dinis
	E-mail: 1000267@isep.ipp.pt

	Nome: JonyD
	E-mail: 1000267@isep.ipp.pt


Nome do Alias: Daniel

	Nome: dherman
	E-mail: daniel.c.herman@gmail.com

	Nome: Daniel Herman
	E-mail: daniel.c.herman@gmail.com


Nome do Alias: wbyoko

	Nome: William Bagayoko
	E-mail: wbagayoko@gmail.com

	Nome: wbyoko
	E-mail: wbagayoko@gmail.com


Nome do Alias: Robin

	Nome: Robin Böhm
	E-mail: robinboehm@googlemail.com

	Nome: Robin Böhm
	E-mail: robinboehm@googlemail.com

	Nome: Robin Böhm
	E-mail: robinboehm@me.com


Nome do Alias: alirezamirian

	Nome: Alireza Mirian
	E-mail: alireza.mirian@gmail.com

	Nome: alirezamirian
	E-mail: alireza.mirian@gmail.com


Nome do Alias: sreeramu

	Nome: Sreenivasan K
	E-mail: sreeramu@gmail.com

	Nome: sreeramu
	E-mail: sreeramu@gmail.com


Nome do Alias: Matias

	Nome: Matias Niemelä
	E-mail: matias@yearofmoo.com

	Nome: Matias Niemelä
	E-mail: matias@yearofmoo.com


Nome do Alias: Tim

	Nome: Tim Ruffles
	E-mail: timruffles@gmail.com

	Nome: Tim Ruffles
	E-mail: timruffles@googlemail.com


Nome do Alias: Jesús

	Nome: Foxandxss
	E-mail: foxandxss@gmail.com

	Nome: Jesús Rodríguez Rodríguez
	E-mail: Foxandxss@gmail.com


Nome do Alias: Bastian

	Nome: campersau
	E-mail: buchholz.bastian@googlemail.com

	Nome: Bastian Buchholz
	E-mail: buchholz.bastian@googlemail.com


Nome do Alias: marcysutton

	Nome: Marcy Sutton
	E-mail: holla@marcysutton.com

	Nome: marcysutton
	E-mail: holla@marcysutton.com


Nome do Alias: marcin-wosinek

	Nome: Marcin Wosinek
	E-mail: marcin.wosinek@gmail.com

	Nome: marcin-wosinek
	E-mail: marcin.wosinek@gmail.com


Nome do Alias: Miško

	Nome: Misko Hevery
	E-mail: misko@hevery.com

	Nome: Miško Hevery
	E-mail: misko@hevery.com

	Nome: Misko Hevery
	E-mail: misko@google.com


Nome do Alias: Karol

	Nome: kwypchlo
	E-mail: kwypchlo@gmail.com

	Nome: Karol Wypchło
	E-mail: kwypchlo@gmail.com


Nome do Alias: pkozlowski-opensource

	Nome: Pawel Kozlowski
	E-mail: pkozlowski.opensource@gmail.com

	Nome: pkozlowski-opensource
	E-mail: pkozlowski.opensource@gmail.com


Nome do Alias: Mohamed

	Nome: Mohamed Samy
	E-mail: Mohamed5amy@users.noreply.github.com

	Nome: Mohamed Daif
	E-mail: daif.control@gmail.com


Nome do Alias: Julie

	Nome: Julie Ralph
	E-mail: ju.ralph@gmail.com

	Nome: Julie
	E-mail: ju.ralph@gmail.com


Nome do Alias: adam77

	Nome: Adam
	E-mail: adam77@gmail.com

	Nome: adam77
	E-mail: adam77@gmail.com


Nome do Alias: Emmanuel

	Nome: Emmanuel DEMEY
	E-mail: demey.emmanuel@gmail.com

	Nome: Emmanuel
	E-mail: demey.emmanuel@gmail.com


Nome do Alias: Chris

	Nome: Chris
	E-mail: chris@anthum.com

	Nome: Chris Chua
	E-mail: chris@thousandeyes.com

	Nome: Chris M
	E-mail: chris@moultrie.org


Nome do Alias: vdyckn

	Nome: Nick Van Dyck
	E-mail: vandyck.nick@outlook.com

	Nome: vdyckn
	E-mail: vandyck.nick@outlook.com


Nome do Alias: Michal

	Nome: cmichal
	E-mail: cmichalb@gmail.com

	Nome: Michal Cieplucha
	E-mail: cmichalb@gmail.com


Nome do Alias: tigbro

	Nome: Tobias Bosch
	E-mail: tbosch1009@gmail.com

	Nome: tigbro
	E-mail: tbosch1009@gmail.com


Nome do Alias: oweitz

	Nome: Ole Weitz
	E-mail: git@kasoban.de

	Nome: oweitz
	E-mail: git@kasoban.de


Nome do Alias: Joseph

	Nome: Joseph Orbegoso Pea
	E-mail: trusktr@users.noreply.github.com

	Nome: Joseph Orbegoso Pea
	E-mail: trusktr@gmail.com


Nome do Alias: ChrisRose

	Nome: Christopher Rose
	E-mail: ChrisRose@users.noreply.github.com

	Nome: ChrisRose
	E-mail: ChrisRose@users.noreply.github.com

	Nome: Chris Rose
	E-mail: christopher.rose@gmail.com


Nome do Alias: rsnapp

	Nome: Rich Snapp
	E-mail: rich.snapp@gmail.com

	Nome: rsnapp
	E-mail: rich.snapp@gmail.com


Nome do Alias: James

	Nome: James deBoer
	E-mail: james@huronbox.com

	Nome: James Brewer
	E-mail: james@punchtab.com

	Nome: James Roper
	E-mail: james@jazzy.id.au


Nome do Alias: Martin

	Nome: martco
	E-mail: martco@gmail.com

	Nome: Martin Cortez
	E-mail: martco@gmail.com


Nome do Alias: Luis

	Nome: Luis Ramón López
	E-mail: lrlopez@gmail.com

	Nome: Luis Ramón López
	E-mail: lrlopez@gmail.com


Nome do Alias: John

	Nome: John K. Paul
	E-mail: john@johnkpaul.com

	Nome: John Kurlak
	E-mail: john@kurlak.com


Nome do Alias: Dusan

	Nome: doodeec
	E-mail: doodeec@gmail.com

	Nome: Dusan Bartos
	E-mail: doodeec@gmail.com


Nome do Alias: MikeMac

	Nome: MikeMcElroy
	E-mail: mikemaccs@gmail.com

	Nome: MikeMac
	E-mail: mikemaccs@gmail.com


Nome do Alias: naomiblack

	Nome: Naomi Black
	E-mail: naomitraveller@gmail.com

	Nome: naomiblack
	E-mail: naomitraveller@gmail.com


Nome do Alias: RoyLING

	Nome: Roy Ling
	E-mail: royling0024@gmail.com

	Nome: RoyLING
	E-mail: royling0024@gmail.com


Nome do Alias: simpulton

	Nome: Lukas Ruebbelke
	E-mail: simpul@gmail.com

	Nome: simpulton
	E-mail: simpul@gmail.com


Nome do Alias: joshkurz

	Nome: Josh Kurz
	E-mail: jkurz25@gmail.com

	Nome: joshkurz
	E-mail: jkurz25@gmail.com


Nome do Alias: Steve

	Nome: snicolai
	E-mail: snicolai@gmail.com

	Nome: Steve Nicolai
	E-mail: snicolai@gmail.com


Nome do Alias: magoswiat

	Nome: Iwona Lalik
	E-mail: iwona.lalik@gmail.com

	Nome: magoswiat
	E-mail: iwona.lalik@gmail.com


Nome do Alias: Deepak

	Nome: deepak-kapoor
	E-mail: kapoordeepak@gmail.com

	Nome: Deepak Kapoor
	E-mail: kapoordeepak@gmail.com


Nome do Alias: Eddie

	Nome: Eddie Monge Jr
	E-mail: eddie@eddiemonge.com

	Nome: Eddie Monge
	E-mail: eddie@eddiemonge.com


Nome do Alias: Jan

	Nome: jankuca
	E-mail: jan@jankuca.com

	Nome: Jan Kuča
	E-mail: jan@jankuca.com


Nome do Alias: James

	Nome: James Dunn
	E-mail: JDDunn9@Gmail.com

	Nome: James
	E-mail: JDDunn9@Gmail.com


Nome do Alias: Jamie

	Nome: Jamie Mason
	E-mail: siunmaru@gmail.com

	Nome: Jamie Mason
	E-mail: siunmaru@googlemail.com


Nome do Alias: Daniel

	Nome: Daniel Tse
	E-mail: daniel@semanaut.com

	Nome: Daniel Tse
	E-mail: daniel@overpunch.com

	Nome: Daniel Zen
	E-mail: daniel@zendigital.com


Nome do Alias: joshrtay

	Nome: Josh Taylor
	E-mail: joshrtay@gmail.com

	Nome: joshrtay
	E-mail: joshrtay@gmail.com


Nome do Alias: sdesmond

	Nome: Spencer
	E-mail: sdsmnd@gmail.com

	Nome: sdesmond
	E-mail: sdsmnd@gmail.com


Nome do Alias: Jens

	Nome: Jens Rantil
	E-mail: jens.rantil@gmail.com

	Nome: Jens Rantil
	E-mail: jens.rantil@telavox.se


Nome do Alias: Laurent

	Nome: Laurent Cozic
	E-mail: laurent@pogopixels.com

	Nome: Laurent
	E-mail: laurent@cozic.net


Nome do Alias: Shyam

	Nome: Shyam Seshadri
	E-mail: shyamseshadri@gmail.com

	Nome: Shyam Seshadri
	E-mail: shyamseshadri@google.com


Nome do Alias: Fredrik

	Nome: Fredrik Bonander
	E-mail: carl.fredrik.bonander

	Nome: Fredrik Bonander
	E-mail: carl.fredrik.bonander@gmail.com


Nome do Alias: Max

	Nome: Max Martinsson
	E-mail: max@cupmanager.net

	Nome: Max
	E-mail: max@cupmanager.net


Nome do Alias: Vojta

	Nome: Vojta Jina
	E-mail: vojta@google.com

	Nome: Vojta Jina
	E-mail: vojta@gemin-i.org


Nome do Alias: Alkis

	Nome: alkis
	E-mail: alkis@evlogimenos.com

	Nome: Alkis Evlogimenos
	E-mail: alkis@evlogimenos.com


Nome do Alias: DiPeng

	Nome: Di Peng
	E-mail: pengdi@google.com

	Nome: DiPeng
	E-mail: pengdi@go.wustl.edu


Nome do Alias: Andres

	Nome: Andres Ornelas
	E-mail: aornelas@google.com

	Nome: Andres Ornelas Mesta
	E-mail: aornelas@google.com


Nome do Alias: Igor

	Nome: Igor Minar
	E-mail: iminar@google.com

	Nome: Igor Minar
	E-mail: iminar@dhcp-172-19-37-154.mtv.corp.google.com

	Nome: iminar
	E-mail: iminar@dhcp-172-19-37-154.mtv.corp.google.com

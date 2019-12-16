# desafiomercadolibre
<h2>Tecnología: </h2>
<ul><li>Java Enterprise</li>
  <li>Spring boot 2.2</li></ul>
  <h2>Prerequisitos</h2>
    <ul><li>java jdk 1.8</li>
  <li>docker</li>
  <li>git</li>
  </ul>
  
<h2>Instalación</h2>
<li>clonar repo:</li>
<code></code>
<li>Creación de imagen:</li>
<code>docker build -t desafiomercadolibre .</code>
<li>Ejecutar imagen:</li>
<code>docker run -d -p8080:8080 desafioml</code>

<h2>invocación</h2>
<b>mutant</b>
<code>
curl -X POST \
  http://localhost:8080/api/v1/mutant \
  -H 'Content-Type: application/json' \
  -d '{
"dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}'</code>

<b>status</b>
<code>
curl -X GET \
  http://18.222.125.243:8080/api/v1/stats
</code>

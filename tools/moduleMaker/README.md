# Tools - ModuleMaker

Arquivo .sh criado para facilitar a criação de módulos no projeto.

O script cria o módulo e realiza as configurações básicas para iniciar o desenvolvimento do módulo.

## Como utilizar o gerador de módulos:

Na raiz do projeto execute o comando:
```
./tools/moduleMaker/moduleMaker.sh
```

Você receberá a solicitação de input do nome do Módulo, então digite o nome do módulo que deseja criar.
  - Ex: `new-card-delivery-tracking`

Você receberá a solicitação de input do caminho do módulo, então digite onde deseja que seu módulo seja criado.

  * Se o módulo que você está criando vai ficar na raiz do projeto você deve utilizar como caminho apenas um ponto. 

  * Se o seu módulo fica dentro de algum outro módulo você deve digitar o nome do módulo a qual ele pertence.
    - Ex: `settings`

Após criação do módulo será exibido as mensagens:

* Module :settings:new-card-delivery-tracking added to settings.gradle
* Remember to organize settings.gradle keeping internal modules together
* File ./settings/new-card-delivery-tracking/.gitignore added to git

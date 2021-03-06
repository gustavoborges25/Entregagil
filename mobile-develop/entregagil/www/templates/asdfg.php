<ion-view view-title="Lances" ng-init="tab=1">
  <link rel="stylesheet" type="text/css" href="css/lances.css">
  <link rel="stylesheet" type="text/css" href="css/notificacoes.css">
  <div class="tabs-striped tabs-top tabs-background-positive tabs-color-light ">
    <div class="tabs fundoLance">
      <a class="tab-item txtMenu col-30" ng-click="tab=1" ng-class="{active : tab==1}">
        DETALHES
      </a>
      <a class="tab-item txtMenu col-30" ng-click="tab=2" ng-class="{active : tab==2}"> 
        DAR LANCE
      </a>
      <a class="tab-item txtMenu col-30" ng-click="tab=3" ng-class="{active : tab==3}">
        CHECKIN
      </a>      
    </div> 
  <ion-content>
    
    <div id="lance" class="detalhes" ng-show="tab==1"></div>

    <div id="lance" class="efetuar" ng-show="tab==2"></div>

    <div id="lance" class="checkin" ng-show="tab==3">
      <div class="checkincard topcard">
        <div class="card status">
          <a class="itemcheck item item-thumbnail-left" href="#/app/lance">
            <div class="imgStatusTransporte">
              <i class="item-image icoStatus flaticon-route-1"></i>
            </div>
            <h2 class="tituloPadrao">Status: Em Transporte</h2>
            <div class="left conteudonotf">
              <i class="icoNot flaticon-time"></i> 
              <span>25/02/2016</span>
            </div>
            <div class="right">
              <i class="icoNot flaticon-time-1"></i>
              <span>18:30</span>
            </div>
          </a>
        </div>
        <div class="card status">
          <a class="itemcheck item item-thumbnail-left" href="#/app/lance">
            <div class="imgStatusSaiu">
              <i class="item-image icoStatus flaticon-route-2"></i>
            </div>
            <h2 class="tituloPadrao">Status: Saiu para Entrega</h2>
            <div class="left conteudonotf">
              <i class="icoNot flaticon-time"></i> 
              <span>25/02/2016</span>
            </div>
            <div class="right"><i class="icoNot flaticon-time-1"></i>18:30</div>
          </a>
        </div>
        <div class="card status">
          <a class="itemcheck item item-thumbnail-left" href="#/app/lance">
            <div class="imgStatusEntregue">
              <i class="item-image icoStatus flaticon-placeholder"></i>
            </div>
            <h2 class="tituloPadrao">Status: Entregue em São Paulo</h2>
            <div class="left conteudonotf">
              <i class="icoNot flaticon-time"></i> 
                <span>26/02/2016</span>
              </div>
            <div class="right">
              <i class="icoNot flaticon-time-1"></i>
              <span>18:30</span>
            </div>            
          </a>
        </div>
      </div>
    </div>
  </ion-content>
</ion-view>

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Observable, Subject } from 'rxjs';
import { Player } from '../player';
import { PlayerService } from '../player.service';
import { map, tap, takeUntil} from 'rxjs/operators';
//import 'rxjs/Rx';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit {
  PlayerRole: any;

 constructor(private playerservice:PlayerService) { }

  playerArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();


  player: Observable<Player[]>;
  players : Player=new Player();
  deleteMessage=false;
  playerlist:any;
  isupdated = false;    
 

  ngOnInit() {
    this.isupdated=false;
    this.dtOptions = {
      pageLength: 6,
      stateSave:true,
      lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],
      processing: true
    };   
    this.playerservice.getPlayerList().subscribe(data =>{
    this.players =data;
    this.dtTrigger.next();
    })
  }
  
  deletePlayer(id: number) {
    this.playerservice.deletePlayer(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage=true;
          this.playerservice.getPlayerList().subscribe(data =>{
            this.players =data
            })
        },
        error => console.log(error));
  }


  updatePlayer(id: number){
    this.playerservice.getPlayer(id)
      .subscribe(
        data => {
          this.playerlist=data           
        },
        error => console.log(error));
  }

  playerupdateform=new FormGroup({
    player_id:new FormControl(),
    player_name:new FormControl(),
    player_email:new FormControl(),
    player_role:new FormControl()
  });

  // updatePly(updply){
  //   this.player=new Player(); 
  //  this.player.player_id=this.PlayerId.value;
  //  this.player.player_name=this.PlayerName.value;
  //  this.player.player_email=this.PlayerEmail.value;
  //  this.player.player_role=this.PlayerRole.value;
  //  console.log(this.PlayerRole.value);
   

  //  this.playerservice.updatePlayer(this.player.player_id,this.player).subscribe(
  //   data => {     
  //     this.isupdated=true;
  //     this.playerservice.getPlayerList().subscribe(data =>{
  //       this.player =data
  //       })
  //   },
  //   error => console.log(error));
  // }

  get PlayerName(){
    return this.playerupdateform.get('player_name');
  }

  get PlayerEmail(){
    return this.playerupdateform.get('player_email');
  }

  get PlayerBranch(){
    return this.playerupdateform.get('player_role');
  }

  get PlayerId(){
    return this.playerupdateform.get('player_id');
  }

  changeisUpdate(){
    this.isupdated=false;
  }
}

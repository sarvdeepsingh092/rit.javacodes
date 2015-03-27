var slaying = true;

var youHit = Math.floor(Math.random() * 2);

var damageThisRound = Math.floor(Math.random()*5 + 1);

var totalDamage = 0;

while(slaying){
 if(youHit){
  console.log("you did " + damageThisRound +" damage");
  totalDamage += damageThisRound;
  
  if(totalDamage>=4){
   console.log("you slayed the dragon");
   slaying = false;
  }
  else{
   youHit = Math.floor(Math.random() * 2);   
  }
 }
 else{
  console.log("the dragon wins, you LOSE!");
  slaying = false;
 }
}
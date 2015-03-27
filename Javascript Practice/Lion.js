var user = prompt("You see a lion roaming around freely, what would you do?").toLowerCase();

switch(user){
  case 'run':
      var fast = prompt("are you fast enough?").toLowerCase();
      if(fast =='yes'){
       console.log("well you might outrun the lion");   
      }
      else{
       console.log("the lion will attack you");   
      }
      break;
  case 'hide':
      var hide=prompt("are you stealthy enough?").toLowerCase();
      if(hide=='yes'){
       console.log("hide in a good place");   
      }
      else{
       console.log("you might die");   
      }
      break;
  case 'stand still':
      var stand=prompt("will you tend to move if the lion comes closer?").toLowerCase();
      if(stand=='yes'){
       console.log("you might die");   
      }
      else{
       console.log("you might be safe");   
      }
      break;
      
  default:
  console.log("DO NOT TRY THAT");
  break;
      
};
var friends = {};

friends.bill={
    firstName: 'Bill',
    lastName: 'gates',
    number: 585-765-0987,
    address: ["one Microsoft", "Gates Boulevard", "WA"]
    };

friends.steve={
    firstName: 'Steve',
    lastName: 'Ballmer',
    number: 585-098-3428,
    address: ["two Microsoft", "Steve Avenue", "CA"]
    };

function list(object){
    for( var obj in object){
     console.log(obj);   
    }
}

function search(name){
    for( var key in friends){
     if(friends[key].firstName==name){
      console.log(friends[key]);
      return friends[key];
     }
    }
}

list(friends);
search('Bill');
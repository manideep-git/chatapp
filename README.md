# chatapp
demo chat app using spring data and mongo db

We have 3 tables mainly:
1.)User
2.)Group
3.)Message

Following are the api's please use post man and import the API's through following link:
https://www.getpostman.com/collections/a59ff9f82e60327a96f5

User Table fields:
userId,Email,password,userName

Group Table fields:
id,groupName,userIds;

Message Table fields:
id,message,fromUser,toUser,messageType,chatGroupId;

	
messageType is Enum:
INDIVIDUAL(Peer to peer chat), GROUP(group chat);



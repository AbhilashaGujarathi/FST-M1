user1Name = input("Player 1 Name : ")
user2Name = input("Player 2 name : ")

user1Choice = input(user1Name + " Please choose Rock / Paper / Scissors ")
user2Choice = input(user2Name + " Please choose Rock /  Paper / Scissors ")

if user1Choice == user2Choice:
    print("you both chosen " + user2Choice + "hence, it's a tie")
elif user1Choice == 'Rock':
    if user2Choice == 'Scissors':
        print(user1Choice + " wins")
    else:
        print(user2Choice + " wins")

elif user1Choice == 'Scissors':
    if user2Choice == 'Paper':
        print("Scissors win!")
    else:
        print("Rock wins!")
elif user1Choice == 'Paper':
    if user2Choice == 'Rock':
        print("Paper wins!")
    else:
        print("Scissors win!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")

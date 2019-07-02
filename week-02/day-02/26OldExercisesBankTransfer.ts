'use strict';

const accounts: any[] = [
  { clientName: 'Igor', accountNumber: 11234543, balance: 203004099.2 },
  { clientName: 'Vladimir', accountNumber: 43546731, balance: 5204100071.23 },
  { clientName: 'Sergei', accountNumber: 23456311, balance: 1353600.0 }
];

// Create function that returns the name and balance of cash on an account in a list
// getNameAndBalance(11234543);
// should return: ['Igor', 203004099.2]
function getNameAndBalance(accountNumber: number) {
  for (let i: number = 0; i < accounts.length; i++) {
    if (accounts[i].accountNumber == accountNumber) {
      return [accounts[i].clientName, accounts[i].balance];
    }
  }
  return 'No such account number.';
}
console.log(getNameAndBalance(11234543));

// Create function that transfers an amount of cash from one account to another
// it should have four parameters:
//  - the accounts
//  - from accountNumber
//  - to accountNumber
//  - amount of cash to transfer
//
// Log "404 - account not found" if any of the account numbers don't exist to the console.
function transferAmount(accountsList, fromAccount: number, toAccount: number, amount: number) {
  let toIndex = -1;
  for (let j: number = 0; j < accountsList.length; j++) {
    if (accountsList[j].accountNumber == toAccount) {
      toIndex = j;
    }
  }
  for (let i: number = 0; i < accountsList.length; i++) {
    if (accountsList[i].accountNumber == fromAccount) {
      accountsList[i].balance -= amount;
      accountsList[toIndex].balance += amount;
    }
  }
}

transferAmount(accounts, 43546731, 23456311, 500.0);
console.log(accounts);
//After printing the "accounts" it should look like:
// const accounts = [
//	{ clientName: 'Igor', accountNumber: 11234543, balance: 203004099.2 },
//	{ clientName: 'Vladimir', accountNumber: 43546731, balance: 5204099571.23 },
//	{ clientName: 'Sergei', accountNumber: 23456311, balance: 1354100.0 }
//]

// export = {
//   getNameAndBalance,
//   transferAmount,
//   accounts
// };
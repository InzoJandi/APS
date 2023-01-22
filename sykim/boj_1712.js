/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1712
 * Level: Bronze II
 * Algorithm: Math
 */

/* Pseudocode *
문자열을 공백 기준으로 split하여 배열(inputData)로 받음.
제품 가격(productPrice) - 변동 비용(variableCost)으로 마진(margin) 값 산출.
Math.floor(fixedCost / margin) + 1로 손익분기점 산출.
단, 마진이 0이하일 경우 손익분기점이 존재하지 않으므로 -1을 출력. 
*/

const fs = require("fs");
const inputData = fs.readFileSync("/dev/stdin").toString().trim().split(" ");

const fixedCost = parseInt(inputData[0]);
const variableCost = parseInt(inputData[1]);
const productPrice = parseInt(inputData[2]);

const margin = productPrice - variableCost;
const productAmount = Math.floor(fixedCost / margin) + 1;

console.log(margin <= 0 ? -1 : productAmount);

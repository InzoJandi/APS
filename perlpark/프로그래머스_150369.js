/*
 * Programers
 * https://school.programmers.co.kr
 * Problem Number: 150369
 * Level: 2
 * Algorithm: Greedy
 */

function solution(cap, n, d, p) {
  let distance = 0;
  let box = 0;
  let space = 0;

  return startDelivery(cap, n, d, p);

  function startDelivery(cap, n, d, p) {
    box = cap;
    space = 0;

    function dropAndPick(i) {
      if (i < 0) {
        distance += n * 2;
        const restD = d.reduce((p, c) => p + c);
        const restP = p.reduce((p, c) => p + c);

        if (restD > 0 || restP > 0) {
          const findIdxD = d.findLastIndex((v) => v > 0);
          const findIdxP = p.findLastIndex((v) => v > 0);

          const findRestIdx = Math.max(findIdxD, findIdxP);
          n = findRestIdx;
          return dropAndPick(findRestIdx);
        }

        // console.log('======FINISNED======', 'distance:', distance);
        return distance;
      }

      if (d[i] > 0) {
        const serve = Math.min(d[i], box);
        box -= serve;
        d[i] -= serve;

        // console.log('---DE-----------------');
        // console.log('i:', i);
        // console.log('serve:', serve);
        // console.log('box:', box);
        // console.log('d:', d);
      }

      if (p[i] > 0) {
        const serve = Math.min(p[i], cap);
        space += serve;
        p[i] -= serve;

        while (box + space > cap && box > 0) {
          box -= 1;
        }

        // console.log('--PI------------------');
        // console.log('i:', i);
        // console.log('space:', space);
        // console.log('box:', box);
        // console.log('d:', d);
        // console.log('p:', p);
      }

      if (box > 0 || space < cap) {
        return dropAndPick(i - 1);
      } else {
        distance += n * 2;
        // console.log('=========NEXT=========', 'distance:', distance);
        // console.log(cap, i, d, p);
        return startDelivery(cap, i, d, p);
      }
    }
    return dropAndPick(n - 1);
  }
}

solution(4, 4, [25, 24, 51, 0], [51, 0, 0, 49]);

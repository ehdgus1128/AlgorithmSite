function solution(survey, choices) {
    var answer = '';
    var identityTable = [
        [
            {
                name : 'R',
                score : 0
            },
            {
                name : 'T',
                score : 0
            }
        ],
        [
            {
                name : 'C',
                score : 0
            },
            {
                name : 'F',
                score : 0
            }
        ],
        [
            {
                name : 'J',
                score : 0
            },
            {
                name : 'M',
                score : 0
            }
        ],
        [
            {
                name : 'A',
                score : 0
            },
            {
                name : 'N',
                score : 0
            }
        ]
    ];
    var suveyScoreTable = [];
    
    for(var i = 0; i < survey.length; i++){
        if(choices !== 4) {            
            if(identityTable.length > 0){
                for(var j = 0; j < identityTable.length; j++){
                    if(identityTable[j].length > 0){
                        for(var k = 0; k < identityTable[j].length; k++){
                            if(choices[i] > 4) {
                                if(survey[i].slice(-1) == identityTable[j][k].name){
                                    identityTable[j][k].score += choices[i] - 4;
                                }                                    
                            } else {
                                if(survey[i].slice(0,1) == identityTable[j][k].name){
                                    identityTable[j][k].score += 4 - choices[i];
                                }
                            }
                        }
                    }       
                }                
            }
        }
    }
    
    for(var i = 0; i < identityTable.length; i++){
        var maxNumber = 0;
        var answerCurrentName = '';
        for(var j = 0; j < identityTable[i].length; j++){
            if(maxNumber < identityTable[i][j].score){
                maxNumber = identityTable[i][j].score;
                answerCurrentName = identityTable[i][j].name;
            }
            
            if(j == identityTable[i].length - 1){
                
                if(maxNumber == 0){
                    answer += identityTable[i][0].name;
                } else {
                    answer += answerCurrentName;
                }
            }
        }
    }
    
    return answer;
}
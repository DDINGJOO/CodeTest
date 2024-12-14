class Solution {
    public int[] solution(String[][] places) {
        /*
            대기실 5개 -> 5*5
            (x1 -x2) + (y1- y2) <=2 X
            파티션 있을경우 가능 
            
            P -> 응시자 있는자리
            O -> 빈 테이블
            X -> 파티션
            
            대기실 뱔로 거리두기를 지키고 있으면 1, 아니면 0 
        */
        
        /*
            X 인 경우 좌우 2칸 상하 2칸 대각 1칸 
            P주변 check > 
        */

        int[]answer  = new int[5];
        for(int i =0 ; i< 5 ;i++)
        {
            answer[i] = check_P(places[i]);
        }
        

        return answer;
    }

    
    

    public int  check_P(String[] room)
    {
        char[][] myChar = new char[5][5];
        for(int i=0 ; i<5; i++)
        {
            for(int j =0 ;j <5 ; j++)
            {
                myChar[i][j] = room[i].charAt(j);    
            }
        }
        // 문자열 전처리 완료
        for(int i =0 ; i<5 ;i++)
        {
            for (int j=0 ; j<5 ;j++)
            {
                if(myChar[i][j] == 'P')
                {
                    //check_left;
                    if(j ==1)
                    {
                        if(myChar[i][0] == 'P')
                           {return 0;}
                    }
                    
                    else if(j >1)
                    {
                        if(myChar[i][j-1] == 'P') 
                        {
                            return  0;
                        }
                        else if(myChar[i][j-2] == 'P' && myChar[i][j-1] != 'X')
                        {
                            return  0;
                        }
                    }
                    
                    //check_right;
                    if(j ==3)
                    {
                        if(myChar[i][4] == 'P'){return 0;}
                    }
                    
                    else if(j <3)
                    {
                        if(myChar[i][j+1] == 'P') 
                        {
                            return  0;
                        }
                        else if(myChar[i][j+2] == 'P' && myChar[i][j+1] != 'X')
                        {
                            return  0;
                        }
                    }
                    
                    //check_down;
                    if(i ==3)
                    {
                        if(myChar[4][j] == 'P'){return 0;}
                    }
                    
                    else if(i <3)
                    {
                        if(myChar[i+1][j] == 'P') 
                        {
                            return  0;
                        }
                        else if(myChar[i+2][j] == 'P' && myChar[i+1][j] != 'X')
                        {
                            return  0;
                        }
                    }

                    //check_up;
                    if(i ==1)
                    {
                        if(myChar[0][j] == 'O' || myChar[0][j] =='X'){}
                        else {return  0;}
                    }
                    
                    else if(i >1)
                    {
                        if(myChar[i-1][j] == 'P') 
                        {
                            return  0;
                        }
                        else if(myChar[i-2][j] == 'P' && myChar[i-1][j] != 'X')
                        {
                            return  0;
                        }
                    }
                    //check_cross;
                    
                    // 북서
                    if(i >=1 && j>=1)
                    {
                        if(myChar[i-1][j-1] == 'P')
                        {
                            if(myChar[i-1][j] != 'X' || myChar[i][j-1] != 'X')
                            {
                                return  0;
                            }
                        }
                    }
                    // 북동
                    if( i>=1 && j<= 3)
                    {
                        if(myChar[i-1][j+1] == 'P')
                        {
                            if(myChar[i-1][j] != 'X' || myChar[i][j+1] != 'X')
                            {
                                return  0;
                            }
                        }
                    }
                    
                                        // 남서
                    if( i<=3 && j>= 1)
                    {
                        if(myChar[i+1][j-1] == 'P')
                        {
                             if(myChar[i+1][j] != 'X' || myChar[i][j-1] != 'X')
                            {
                                return  0;
                            }
                        }
                    }
                    
                                        // 남동
                    if( i<=3 && j<= 3)
                    {
                        if(myChar[i+1][j+1] == 'P')
                        {
                            if(myChar[i+1][j] != 'X' || myChar[i][j+1] != 'X')
                            {
                                return  0;
                            }
                        }
                    }
                }
            }
            
            
        }
        return 1;
    }
}


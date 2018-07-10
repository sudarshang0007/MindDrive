package com.siemens.hackathon.service;

import org.springframework.stereotype.Service;

import com.siemens.hackathon.entity.MindDriveEntity;

@Service
public class MindDriveServiceImpl implements MindDriveService {

    @Override
    public int evaluateCurrentPattern(MindDriveEntity mindDriveEntity) {
        int rating = 1;

        int speedWeight = 3;
        int rpmWeight = 1;
        int engineLoadWeight = 3;
        int engineTempWeight = 2;
        double speedValue = 0;
        double rpmValue = 0;
        double tempValue = 0;
        double engineLoadValue = 0;
        if(mindDriveEntity.getSpeed()!=null)
        speedValue = Double.parseDouble(mindDriveEntity.getSpeed());

        if(mindDriveEntity.getRpm()!=null)
        rpmValue = mindDriveEntity.getRpm();

        if(mindDriveEntity.getEngCoolantTmp()!=null)
        tempValue = mindDriveEntity.getEngCoolantTmp();

        if(mindDriveEntity.getEngLoad()!=null)
        engineLoadValue =mindDriveEntity.getEngLoad();

        double score = ((speedWeight*speedValue)+(rpmWeight*rpmValue)+(engineTempWeight*tempValue)+(engineLoadWeight*engineLoadValue))
                        /(speedWeight+rpmWeight+engineTempWeight+engineLoadValue);
        //System.out.print("Score: "+score);
        if(score>100)
            rating = 5;
        else if(score>98)
            rating = 4;
        else if(score>94)
            rating = 3;
        else if(score>92)
            rating = 2;
        return rating;
    }

   /* public static void main(String []args)
    {
        MindDriveEntity mindDriveEntity = new MindDriveEntity();
        mindDriveEntity.setSpeed("120");
        mindDriveEntity.setRpm("1500");
        mindDriveEntity.setEngCoolantTmp("80");
        mindDriveEntity.setEngLoad("14.50");
        MindDriveServiceImpl mindDriveService = new MindDriveServiceImpl();
        System.out.print("**"+mindDriveService.evaluateCurrentPattern(mindDriveEntity));
    }*/
}

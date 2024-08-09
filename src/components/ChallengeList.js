import { Challenge } from "./Challenge";


export function ChallengeList({challenges,onDelete}){
    return(
        <div className="list-group">
            {challenges.map(challenge=>(
                  <Challenge key={challenge.id} challenge={challenge} deleteRow={onDelete}/>
            ))}
        </div>
    );
}




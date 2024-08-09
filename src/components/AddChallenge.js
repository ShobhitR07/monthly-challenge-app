import { useState } from "react";
import axios from "axios";

export function AddChallenge({onChallengeAdded}){
    const [month,setMonth]=useState('') ;
    const [description,setDescription]=useState('') ;

    

    const handleSubmit=async(e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/challenges',{month,description});
            setDescription('') ;
            setMonth('');
            onChallengeAdded() ;
        } catch (error) {
            console.error("error posting challenges",error) ;
        }
    }
    return(
        <div className="card my-5">
        <div className="card-header">Add New Challenge</div>
        <div className="card-body">
        <form onSubmit={handleSubmit}>
        <div className="mb-3">
            <label htmlFor="month" className="form-label">Month</label>
            <input placeholder="ex. January" className="form-control" required type="text" id="month" value={month} onChange={(e)=>setMonth(e.target.value)}></input>
        </div>
         <div className="mb-3">
         <label htmlFor="description" className="form-label">Description</label>
         <input placeholder="description" className="form-control" required type="text" id="description" value={description} onChange={(e)=>setDescription(e.target.value)}></input>
     </div>
     <button type="submit" className="btn btn-primary">submit</button>
     </form>
     </div>
     </div>
    );
}
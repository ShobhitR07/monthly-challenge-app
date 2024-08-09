
import { useEffect, useState } from 'react';
import './App.css';
import { ChallengeList } from './components/ChallengeList';
import axios from 'axios';
import { AddChallenge } from './components/AddChallenge';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {

  const[challenges,setChallenges]=useState([]) ;

  useEffect(()=>{
    fetchChallenges();
  },[]);
  const fetchChallenges=async()=>{
    try {
      const response=await axios.get('http://localhost:8080/challenges') ;
      setChallenges(response.data) ;
    } catch (error) {
      console.error("error fetching challenges",error) ;
    }
  
  };

   const handleChallengeAdded=()=>{
    fetchChallenges() ;
  }

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/challenges/${id}`);
      // Update the state by filtering out the deleted challenge
      setChallenges(prevChallenges => prevChallenges.filter(challenge => challenge.id !== id));
    } catch (error) {
      console.error("error deleting challenge", error);
    }
  };

  return (
    <div className="container mt-5">
      
      <h1 className='text-center mb-4'>Monthly Challenges</h1>
      <AddChallenge onChallengeAdded={handleChallengeAdded}/>
      <ChallengeList challenges={challenges} onDelete={handleDelete}/>
         
    </div>
  );
}

export default App;

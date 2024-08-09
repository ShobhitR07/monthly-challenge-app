import axios from "axios"

export function Challenge({challenge,deleteRow}){

    // const deleteRow = (id, e) => {  
    //     axios.delete(`http://localhost:8080/challenges/${id}`)  
    //       .then(res => {  
    //         console.log(res);  
    //         console.log(res.data);   
    //       })
    //       .catch(error => {
    //         console.error("There was an error deleting the row!", error);
    //       });
    // };
    
    return(
        <a href="" className="list-group-item list-group-item-action ">
        <div className="d-flex w-100  justify-content-between">
            <h5>{challenge.month}</h5>
        </div>
        
        <p className="mb-1">{challenge.description}</p>
        <button className="btn btn-danger" onClick={() => deleteRow(challenge.id)}  >Delete</button>
        </a>
    ) ;

}




import '../App.css';
import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {useDispatch, useSelector} from 'react-redux';
import { withRouter, useParams } from 'react-router';
import {getClient} from '../reducers/index'
import AddVisit from './AddVisit';


const Client = (match) => {
    const dispatch = useDispatch()
    let { clientId } = useParams()
    React.useEffect(() => {
        if(clientId){
            dispatch(getClient(clientId))
        }
    }, [clientId])
    let currentClient = useSelector(state => state.mainReducer.currentClient)
    // let visits = currentClient && currentClient.visits
  return (
    
      currentClient && <div>

       <div style={{'textAlign': 'center'}}>
         {/* <h2>Привет, Админ!</h2> */}
         <h2>{currentClient.name}!</h2>
       </div>

       <AddVisit maxId={currentClient.visits && currentClient.visits[currentClient.visits.length - 1].id} /> 
      
      <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell align="left">Дата</TableCell>
            <TableCell align="left">Название</TableCell>
            <TableCell align="left">Стоимость</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {currentClient.visitRows.map((visit) => (
            <TableRow
              key={visit.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
             
              <TableCell align="left">{new Date(visit.visitDate).toLocaleDateString('ru')}</TableCell>
              <TableCell align="left">{visit.finalTitle}</TableCell>
              <TableCell align="left">{visit.finalCost}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </div>
  );
}

export default withRouter(Client);
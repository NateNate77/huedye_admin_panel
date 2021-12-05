
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
import { Link } from 'react-router-dom';
import { Box, Button, Modal, Typography } from '@mui/material';
import AddClient from './AddClient';
import { getClients } from '../reducers';


const ClientsTable = () => {
  const dispatch = useDispatch()
  React.useEffect(() => {
    dispatch(getClients())
}, [])

    let clients = useSelector(state => state.mainReducer.clients)
    let currentUser = useSelector(state => state.mainReducer.currentUser)

  return (
    
      <div>

       <div style={{'textAlign': 'center'}}>
         {/* <h2>Привет, Админ!</h2> */}
         <h2>Привет, {currentUser}!</h2>
       </div>
       
       <AddClient/>
      
      <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell>ФИО</TableCell>
            <TableCell align="right">Телефон</TableCell>
            <TableCell align="right">Последнее посещение</TableCell>
            <TableCell align="right">Количество посещений</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {clients.map((client) => (
            <TableRow
              key={client.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                <Link to={`/client/${client.id}`}>{client.name}</Link>
              </TableCell>
              <TableCell align="right">{client.phone}</TableCell>
              <TableCell align="right">{client.lastVisit && new Date(client.lastVisit).toLocaleDateString('ru')}</TableCell>
              <TableCell align="right">{client.visitsCount}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </div>
  );
}

export default ClientsTable;

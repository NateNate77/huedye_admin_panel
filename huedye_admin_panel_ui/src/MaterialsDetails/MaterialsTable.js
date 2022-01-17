
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
import { getMaterials } from '../reducers';


const MaterialsTable = () => {

    const dispatch = useDispatch()
  React.useEffect(() => {
    dispatch(getMaterials())
}, [])

  let materials = useSelector(state => state.mainReducer.materials)
  return (
    
      <div>

       <div style={{'textAlign': 'center'}}>
  
       </div>
      
      <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell align="right">Бренд</TableCell>
            <TableCell align="right">Наименование</TableCell>
            <TableCell align="right">Количество</TableCell>
            <TableCell align="right">Стоимость</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {materials.map((material) => (
            <TableRow
              key={material.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {material.brandName}
              </TableCell>
              <TableCell align="right">{material.name}</TableCell>
              <TableCell align="right">{material.amount}</TableCell>
              <TableCell align="right">{material.cost}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </div>
  );

}

export default MaterialsTable;
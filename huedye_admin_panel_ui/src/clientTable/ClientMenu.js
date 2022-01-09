import { MoreVert } from "@mui/icons-material"
import { Box, IconButton, Menu, MenuItem, Modal } from "@mui/material"
import { Fragment, useState } from "react"
import { useDispatch } from "react-redux"
import { deleteClient, editClient } from "../reducers"
import AddClientForm from "./AddClientForm"

const ITEM_HEIGHT = 48

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
  };

const ClientMenu = ({client}) => {
  const dispatch = useDispatch()
  const [ anchorEl, setAnchorEl ] = useState(null)
  const open = Boolean(anchorEl)

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget)
  }

  const handleClose = () => {
    setAnchorEl(null)
  }

    const [editOpen, setEditOpen] = useState(false);
    const handleEditOpen = () => {
        handleClose();
        setEditOpen(true);
    }
    const handleEditClose = () => setEditOpen(false);

    const submitClient = (values) => { 
      dispatch(editClient({ ...values}, client.id))
      handleEditClose();
    }

    const handleDeleteClient = () => {
        handleClose();
        let result = window.confirm('Ты реально хочешь удалить?');
        if(result){
            dispatch(deleteClient(client.id));
        }
    }


  return (
    <div>
      <Fragment>
        <IconButton aria-label="more" aria-controls="long-menu" aria-haspopup="true" onClick={handleClick}>
          <MoreVert />
        </IconButton>
        <Menu
          id="long-menu"
          anchorEl={anchorEl}
          keepMounted
          open={open}
          onClose={handleClose}
          PaperProps={{
            style: {
              maxHeight: ITEM_HEIGHT * 6.5,
              width: 200,
              backgroundColor: '#243041',
              color: 'white',
              fontWeight: '400'
            }
          }}
        >
          <MenuItem onClick={handleEditOpen}>Изменить</MenuItem> 
          <MenuItem onClick={handleDeleteClient}>Удалить</MenuItem>
        </Menu>
      </Fragment>
      <Modal
          open={editOpen}
          onClose={handleEditClose}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={style}>
            <AddClientForm onSubmit={submitClient} client={client}/>
          </Box>
        </Modal>
    </div>
  )
}

export default ClientMenu
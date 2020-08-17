import React from 'react';
import AppBar from '@material-ui/core/AppBar/index';
import TextField from '@material-ui/core/TextField/index';
import Button from '@material-ui/core/Button/index';
import Typography from '@material-ui/core/Typography/index';
import IconButton from "@material-ui/core/IconButton/index";

import Toolbar from "@material-ui/core/Toolbar/index";
import makeStyles from "@material-ui/core/styles/makeStyles";



const onClickEvent=(props)=>{
    alert(props)
}


 function FormUserDetail(props){
     return(
             (<div>
                 <AppBar position="static">
                     <Toolbar>
                         <Button onClick={()=>onClickEvent('Login')} color="inherit">Login</Button>
                         <Button color="inherit">Søg institution</Button>
                         <Button color="inherit">Skriv et opslag</Button>
                     </Toolbar>
                 </AppBar>
                 </div>
             )
     )


 };

 export default FormUserDetail;


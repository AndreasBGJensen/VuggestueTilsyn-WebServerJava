import React from 'react';
import { makeStyles} from "@material-ui/core/styles";
import { Grid, Paper, Button , Typography, Container, Card} from "@material-ui/core";


const useStyles = makeStyles((theme) => ({
    grid:{
        width: '100px',
        margin: '0px'
    },
    paper:{
        padding: theme.spacing(2),
        color: theme.palette.text.secondary,
        background: theme.palette.success.light,
    }

}));

function GridApp({value}) {

    const classes = useStyles;
    return (
        <Grid container spacing={2} className={classes.grid}>
            <Grid item xs={12} md={6}>
                <Container>
                    <Typography variant="h3" gutterBottom>
                        Here gores the button
                    </Typography>
                    <Button color="primary" variant="contained">{value}</Button>
                </Container>

                <Paper className={classes.paper}>1</Paper>
            </Grid>
            <Grid item xs={7} md={6}>
                <Button color="secondary" variant="outlined" >I'm a button</Button>
            </Grid>
        </Grid>
    )

}

export default GridApp;
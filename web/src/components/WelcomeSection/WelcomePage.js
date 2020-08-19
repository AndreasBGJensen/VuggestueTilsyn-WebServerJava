import React from 'react'
import Footer from "../Footer/Footer";
import FormUserDetail from "../Header/FormUserDetail";
import GridApp from "../../BackgroungGrid";
import Grid from "@material-ui/core/Grid";
import makeStyles from "@material-ui/core/styles/makeStyles";
import ContentTable from "../ContentTable";
import TestCollapseTable from "../TestCollapseTable";
import NewTable from "../NewTable";
import SearchBar from "../SearchBar";
import withStyles from "@material-ui/core/styles/withStyles";



const useStyles = theme => ({
    root: {
        flexGrow: 1,
        alignItems: 'center',
        textAlign: 'center',
    },
    leftNRightGrid: {
        padding: theme.spacing(2),
        color: theme.palette.text.secondary,

    },
    centerGrid: {
        padding: theme.spacing(2),
        color: theme.palette.text.secondary,
    }
});



class WelcomePage extends React.Component {
    constructor(props) {
        super(props);
        this.state ={
            searchWord:"",
        };
    }

/*
This update searchword is prop in SearchBar component. This is so that that we can pass the searchword to the NewTable component.
The searchWord is used so that we are able to filter the institution list.
 */
updateSearchWord = newWord =>{
        this.setState({searchWord:newWord});
    console.log(this.state.searchWord);

}


render(){
    const { classes } = this.props;
        return(
            <div>


                        <FormUserDetail/>

                    <Grid container className={classes.root}>
                        <Grid item className={classes.leftNRightGrid} xs={1}>
                            <h2  >sdfsdfsdf</h2>
                        </Grid>
                        <Grid item xs={10} className={classes.centerGrid}>
                            <SearchBar onChange={(value)=>this.updateSearchWord(value)}/>
                            <NewTable searchword={this.state.searchWord}/>
                        </Grid>

                        <Grid item className={classes.leftNRightGrid} xs={1}>
                            <h2>sdfsdfsdf</h2>
                        </Grid>
                    </Grid>

                        <Footer/>


            </div>
        )
}
}

export default withStyles(useStyles)(WelcomePage);